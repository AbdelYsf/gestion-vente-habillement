package presentation;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import service.business.Fournisseur;
import service.business.IUser;
import service.business.UserImpleService;

@ManagedBean(name = "managedFounri")
@SessionScoped
public class ManagedFournisseur {
	private Fournisseur fourn;
	private Fournisseur updateEligibleFourni;
	private final IUser userws;
	private List<Fournisseur> listFourni;
	private String motCle;

	public ManagedFournisseur() {
		super();
		setFourn(new Fournisseur());
		final UserImpleService userimpleService = new UserImpleService();
		userws = userimpleService.getUserImplePort();
		motCle = "";
	}

	public void preLoad() {
		if (motCle == "") {
			listFourni = userws.getAllFournisseurs();
		} else {
			listFourni = userws.getFournisseursByMc(motCle);
			motCle = "";
		}

	}

	public String cherchermc() {
		return null;
	}

	public Fournisseur getFourn() {
		return fourn;
	}

	public void setFourn(final Fournisseur fourn) {
		this.fourn = fourn;
	}

	public String addFournisseur() {
		if (userws.addFournisseur(fourn) != null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "bien ajouté"));
			return null;
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", " n'est pas ajouter"));
			return null;
		}
	}

	public List<Fournisseur> getListFourni() {
		return listFourni;
	}

	public void setListFourni(final List<Fournisseur> listFourni) {
		this.listFourni = listFourni;
	}

	public String deleteFournisseur(final Fournisseur f) {
		if (userws.deleteFournisseur(Integer.valueOf(f.getIdFournisseur()))) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "bien supprimé"));
			return null;
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", " mal supprimé"));
			return null;
		}

	}

	public String updateFournisseur() {
		userws.updateFournisseur(updateEligibleFourni);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successful", "bien mis a jour"));
		return "fournisseur.xhtml?faces-redirect=true";
	}

	public Fournisseur getUpdateEligibleFourni() {
		return updateEligibleFourni;
	}

	public String setUpdateEligibleFourni(final Fournisseur updateEligibleFourni) {
		this.updateEligibleFourni = updateEligibleFourni;
		System.out.println(updateEligibleFourni.getTele());
		return "updateFournissseur.xhtml?faces-redirect=true";
	}

	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(final String motCle) {
		this.motCle = motCle;
	}

}
