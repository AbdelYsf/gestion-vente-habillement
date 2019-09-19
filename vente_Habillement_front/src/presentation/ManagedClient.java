package presentation;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import service.business.Client;
import service.business.IUser;
import service.business.UserImpleService;

@ManagedBean
@SessionScoped
public class ManagedClient {

	private Client client;
	private Client eligibleUpdateClient;
	private IUser userws;
	private List<Client> listClient;
	private String motCle;

	public ManagedClient() {
		super();
		client = new Client();
		final UserImpleService userimpleService = new UserImpleService();
		userws = userimpleService.getUserImplePort();
		motCle = "";

	}

	// @PostConstruct
	public void init() {
		if (motCle == "") {
			listClient = userws.getAllClient();
		} else {
			listClient = userws.getClientByMc(motCle);
			motCle = "";
		}
	}

	public String addClient() {
		if (userws.addClient(client) != null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "bien ajouté"));
			return null;
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", " n'est pas ajouter"));
			return null;
		}
	}

	public String deleteClient(final Client c) {
		if (userws.deleteClient(Integer.valueOf(c.getIdClient()))) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "bien supprimé"));
			return null;
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", " mal supprimer"));
			return null;
		}

	}

	public String cherchermc() {
		return null;
	}

	public String updateClient() {

		if (userws.updateClient(eligibleUpdateClient) != null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successful", "bien mis a jour"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", " "));
		}
		return "client.xhtml?faces-redirect=true";
	}

	public Client getClient() {
		return client;
	}

	public void setClient(final Client client) {
		this.client = client;
	}

	public Client getEligibleUpdateClient() {
		return eligibleUpdateClient;
	}

	public String setEligibleUpdateClient(final Client eligibleUpdateClient) {
		this.eligibleUpdateClient = eligibleUpdateClient;
		return "updateClient.xhtml?faces-redirect=true";
	}

	public IUser getUserws() {
		return userws;
	}

	public void setUserws(final IUser userws) {
		this.userws = userws;
	}

	public List<Client> getListClient() {
		return listClient;
	}

	public void setListClient(final List<Client> listClient) {
		this.listClient = listClient;
	}

	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(final String motCle) {
		this.motCle = motCle;
	}
}
