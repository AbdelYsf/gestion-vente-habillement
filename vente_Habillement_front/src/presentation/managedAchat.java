package presentation;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import service.business.Achat;
import service.business.Article;
import service.business.ArticleImpleService;
import service.business.Fournisseur;
import service.business.IArticle;
import service.business.IUser;
import service.business.UserImpleService;

@ManagedBean
@SessionScoped
public class managedAchat {
	private Achat achat;
	private Achat achatDetail;
	private List<Achat> listAchat;
	private IArticle articleService;
	private List<Fournisseur> listFournisseur;
	private List<Article> listArticle;
	private String date;
   private String motCle;
	private String chosenArticle;
	
	private IUser fournisService;
	
	private String chosenFournisseur;
	public List<Fournisseur> getListFournisseur() {
		return listFournisseur;
	}

	public void setListFournisseur(List<Fournisseur> listFournisseur) {
		this.listFournisseur = listFournisseur;
	}
	public List<Article> getListArticle() {
		return listArticle;
	}

	public void setListArticle(List<Article> listArticle) {
		this.listArticle = listArticle;
	}

	public String getChosenFournisseur() {
		return chosenFournisseur;
	}

	public void setChosenFournisseur(String chosenFournisseur) {
		this.chosenFournisseur = chosenFournisseur;
	}

	public String getChosenArticle() {
		return chosenArticle;
	}

	public void setChosenArticle(String chosenArticle) {
		this.chosenArticle = chosenArticle;
	}

	
	

	public managedAchat() {
		super();
		achat= new Achat();
		ArticleImpleService articleImpleService= new ArticleImpleService();
		articleService = articleImpleService.getArticleImplePort();
		motCle="";
		//webservice de fournisseur 
		UserImpleService userimpleService = new UserImpleService();
		 fournisService= userimpleService.getUserImplePort();
	}

	public void init() {
		listAchat= articleService.getAllAchats();
		listArticle=articleService.getAllArticles();
		listFournisseur=fournisService.getAllFournisseurs();
		if(motCle=="") {
			listAchat=articleService.getAllAchats();
		}else{
			listAchat=articleService.getAchatBymotcle(motCle);
			motCle="";
		}
	}

	public List<Achat> getListAchat() {
		

		return listAchat;
	}


	public void setListAchat(List<Achat> listAchat) {
		this.listAchat = listAchat;
	}

   public String cherchermc() {
	   return null;
   }
	public IArticle getArticleService() {
		return articleService;
	}
	public void setArticleService(IArticle articleService) {
		this.articleService = articleService;
	}
	public String addAchat() {
		Fournisseur f=new Fournisseur();
		f.setIdFournisseur(chosenFournisseur);
		Article ar = new Article();
		ar.setRef(chosenArticle);
		achat.setFournisseur(f);
		achat.setArticle(ar);
		achat.setDate(date.toString());
		
		articleService.addAchat(achat);
		return null;
	}
	public Achat getAchat() {
		return achat;
	}
	public void setAchat(Achat achat) {
		this.achat = achat;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Achat getAchatDetail() {
		return achatDetail;
	}

	public String setAchatDetail(Achat achatDetail) {
		this.achatDetail = achatDetail;
		return "achatDetails.xhtml?faces-redirect=true";
	}

	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

}
