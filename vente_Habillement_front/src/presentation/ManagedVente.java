package presentation;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import service.business.Article;
import service.business.ArticleImpleService;
import service.business.Client;
import service.business.Credit;
import service.business.IArticle;
import service.business.IUser;
import service.business.UserImpleService;
import service.business.Vente;
import service.business.Versement;

@ManagedBean
@SessionScoped
public class ManagedVente {

	IArticle articleService;
	IUser clientService;
	private List<Vente> listVente;
	private List<Client> listClient;
	private List<Article> listArticle;
	private List<Vente> listVenteAvecCredit;
	private String DateVente;
	private String dateExpirationCredit;
	private String choosenClient;
	private String choosenArticle;
	private double mtVersement;
	private String dateVeresement;
	private List<Article> neededArticles;
	private Vente detailVente;
	private Article selectedArticle;
	private Vente vente;
	private Vente eligibleUpdateVente;

	private Vente nouvauVente;

	private String echageArticleRef;

	private String motcle;

	private boolean showCrdit;

	private String notificationMsg;

	private String moreInfoClient;

	private List<Vente> listVentsOfAClient;
	private double totalCreditOfAclient;

	public ManagedVente() {
		super();
		vente = new Vente();
		final ArticleImpleService articleWS = new ArticleImpleService();
		articleService = articleWS.getArticleImplePort();

		final UserImpleService userWS = new UserImpleService();
		clientService = userWS.getUserImplePort();
		motcle = "";
		dateVeresement = "";
		listVenteAvecCredit = new ArrayList<Vente>();
	}

	public void init() {
		listArticle = articleService.getAllArticles();

		listClient = clientService.getAllClient();

		if (motcle == "") {
			listVente = articleService.getAllVents();
			motcle = "";
		} else {
			listVente = articleService.getVenteBymotcle(motcle);
			motcle = "";
		}
		neededArticles = articleService.getNeededArticle();
		String msg = null;
		notificationMsg = "pensez a reinlementer l article suivante :";
		for (final Article art : neededArticles) {
			msg = art.getDesignation().getNomDesignation() + " taille " + art.getTaille();
//			FacesContext.getCurrentInstance().addMessage(null,
//					new FacesMessage(FacesMessage.SEVERITY_WARN, "pensez a reinlementer l'article suivante ", msg));
			notificationMsg += msg + " , ";
		}
//		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successful",
//				"Your message: " + neededArticles.get(0).getDesignation().getNomDesignation()));

	}

	public void initCreditView() {
		listVenteAvecCredit = articleService.getAllVentsAvcCredit();
	}

	public String addVente() {

		// test if the quantity chosen available
		int availableQte = 0;
		for (final Article arti : listArticle) {
			if (arti.getRef().equals(choosenArticle)) {
				availableQte = Integer.parseInt(arti.getQuantite());
			}
		}
		if (vente.getQuantite() > availableQte) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
					" la quantite choisi n'est pas disponible dans le stock"));
			return null;
		} else {

			selectedArticle = findSelectedArticle(choosenArticle);
			final Article a = new Article();
			final Client c = new Client();
			a.setRef(choosenArticle);
			c.setIdClient(choosenClient);
			vente.setArticle(a);
			vente.setClient(c);
			vente.setTypeOperation("vente");
			vente.setDateVente(DateVente);
			vente.setMantant(Double.parseDouble(selectedArticle.getPrix()) * vente.getQuantite());
			if (showCrdit) {
				vente.setCredit(addCredit());
			} else {
				final Credit cre = new Credit();
				cre.setIdCredit(0);
				vente.setCredit(cre);
			}

			articleService.addVente(vente);

			return "vente.xhtml?faces-redirect=true";
		}
	}

	public String annulerVente(final Vente v) {
		if (articleService.annulerVente(v)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "la vente a ete annulé"));
			return null;
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", " mal annuler "));
			return null;
		}

	}

	private Credit addCredit() {
		final Credit c = new Credit();
		c.setMontantCredit(Double.parseDouble(selectedArticle.getPrix()) * vente.getQuantite());
		c.setDateExpiration(dateExpirationCredit);
		final int pk = articleService.addCredit(c);
		c.setIdCredit(pk);
		return c;
	}

	public void showCreditDetails(final ValueChangeEvent event) {
		showCrdit = !showCrdit;

	}

	public String addVerement() {
		final Versement v = new Versement();
		v.setMantantVersement(mtVersement);
//		SimpleDateFormat smf = new SimpleDateFormat("mm/dd/yyyy");
		if (mtVersement > detailVente.getCredit().getMontantReste()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
					"le montant entré depassele rest a payer!"));
			return null;
		}
		v.setDateVersement(dateVeresement);
		detailVente.getCredit().setMontantReste(detailVente.getCredit().getMontantReste() - mtVersement);
		v.setIdCredit(detailVente.getCredit().getIdCredit());
		if (articleService.addVersement(v) == true) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", " versement bien ajouté"));
			detailVente.getCredit().getVersement().add(v);
			return null;
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", " veresement mal ajouter"));
			return null;
		}
	}

	public String echanger() {
		nouvauVente = new Vente();
		final String oldArticleRef = eligibleUpdateVente.getArticle().getRef();

		selectedArticle = findSelectedArticle(echageArticleRef);

		nouvauVente.setArticle(selectedArticle);

		nouvauVente.setMantant(Double.parseDouble(selectedArticle.getPrix()) * eligibleUpdateVente.getQuantite());
		nouvauVente.setTypeOperation("echange");
		nouvauVente.setQuantite(eligibleUpdateVente.getQuantite());
		articleService.echangerVente(eligibleUpdateVente, nouvauVente);
		return "vente.xhtml?faces-redirect=true";
	}

	// get more info about a client
	public String moreInfoAboutAClient() {
		System.out.println(moreInfoClient);
		listVentsOfAClient = articleService.getAllVentsOfAclient(moreInfoClient);
		totalCreditOfAclient = articleService.getTotalCreditParClient(moreInfoClient);

		return null;
	}

//	public void valueChanged(final ValueChangeEvent event) {
//		
//		System.out.println(moreInfoClient);
//		
//	}

	public String chercherparmc() {
		return "vente.xhml?faces-redirect=true";
	}

	public String getMotcle() {
		return motcle;
	}

	public void setMotcle(final String motcle) {
		this.motcle = motcle;
	}

	// getters & setters
	public Vente getVente() {
		return vente;
	}

	public void setVente(final Vente vente) {
		this.vente = vente;
	}

	public String getChoosenClient() {
		return choosenClient;
	}

	public void setChoosenClient(final String choosenClient) {
		this.choosenClient = choosenClient;
	}

	public String getChoosenArticle() {
		return choosenArticle;
	}

	public void setChoosenArticle(final String choosenArticle) {
		this.choosenArticle = choosenArticle;
	}

	public List<Vente> getListVente() {
		return listVente;
	}

	public void setListVente(final List<Vente> listVente) {
		this.listVente = listVente;
	}

	public List<Client> getListClient() {
		return listClient;
	}

	public void setListClient(final List<Client> listClient) {
		this.listClient = listClient;
	}

	public List<Article> getListArticle() {
		return listArticle;
	}

	public void setListArticle(final List<Article> listArticle) {
		this.listArticle = listArticle;
	}

	public String getDateVente() {
		return DateVente;
	}

	public void setDateVente(final String dateVente) {
		DateVente = dateVente;
	}

	public boolean isShowCrdit() {
		return showCrdit;
	}

	public void setShowCrdit(final boolean showCrdit) {
		this.showCrdit = showCrdit;
	}

	public String getDateExpirationCredit() {
		return dateExpirationCredit;
	}

	public void setDateExpirationCredit(final String dateExpirationCredit) {
		this.dateExpirationCredit = dateExpirationCredit;
	}

	private Article findSelectedArticle(final String id) {
		for (final Article art : listArticle) {
			if (art.getRef().trim().equalsIgnoreCase(id.trim())) {
				return art;
			}
		}
		return null;
	}

	public Vente getDetailVente() {
		return detailVente;
	}

	public String setDetailVente(final Vente detailVente) {
		System.out.println("size creditv:" + detailVente.getCredit().getVersement().size());
		this.detailVente = detailVente;
		return "detailVente.xhtml?faces-redirect=true";
	}

	public double getMtVersement() {
		return mtVersement;
	}

	public void setMtVersement(final double mtVersement) {
		this.mtVersement = mtVersement;
	}

	public Vente getEligibleUpdateVente() {
		return eligibleUpdateVente;
	}

	public String setEligibleUpdateVente(final Vente eligibleUpdateVente) {

		this.eligibleUpdateVente = eligibleUpdateVente;
		return "updateVente.xhtml?faces-redirect=true";
	}

	public String getEchageArticleRef() {
		return echageArticleRef;
	}

	public void setEchageArticleRef(final String echageArticleRef) {
		this.echageArticleRef = echageArticleRef;
	}

	public String getDateVeresement() {
		return dateVeresement;
	}

	public void setDateVeresement(final String dateVeresement) {
		this.dateVeresement = dateVeresement;
	}

	public List<Vente> getListVenteAvecCredit() {
		return listVenteAvecCredit;
	}

	public void setListVenteAvecCredit(final List<Vente> listVenteAvecCredit) {
		this.listVenteAvecCredit = listVenteAvecCredit;
	}

	public String getNotificationMsg() {
		return notificationMsg;
	}

	public void setNotificationMsg(final String notificationMsg) {
		this.notificationMsg = notificationMsg;
	}

	public String getMoreInfoClient() {
		return moreInfoClient;
	}

	public void setMoreInfoClient(final String moreInfoClient) {

		this.moreInfoClient = moreInfoClient;
	}

	public List<Vente> getListVentsOfAClient() {
		return listVentsOfAClient;
	}

	public void setListVentsOfAClient(final List<Vente> listVentsOfAClient) {
		this.listVentsOfAClient = listVentsOfAClient;
	}

	public double getTotalCreditOfAclient() {
		return totalCreditOfAclient;
	}

	public void setTotalCreditOfAclient(final double totalCreditOfAclient) {
		this.totalCreditOfAclient = totalCreditOfAclient;
	}

}
