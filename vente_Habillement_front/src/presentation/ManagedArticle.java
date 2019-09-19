package presentation;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import service.business.Article;
import service.business.ArticleImpleService;
import service.business.Categorie;
import service.business.Designation;
import service.business.IArticle;

@ManagedBean
@SessionScoped
public class ManagedArticle {

	private Article article;
	private List<Article> listAricle;
	private Article eligibleUpdateArticle;
	private double prix;
//	 private int qte;
	private String motCle;
	private IArticle ArticleService;
	private List<Article> searchedList;

	public void init() {
		if (motCle == "") {
			listAricle = ArticleService.getAllArticles();
			motCle = "";
		} else {
			listAricle = ArticleService.getArticlesByMotcle(motCle);
			motCle = "";
		}

	}

	public ManagedArticle() {
		super();
		article = new Article();
		eligibleUpdateArticle = new Article();
		eligibleUpdateArticle.setDesignation(new Designation());
		eligibleUpdateArticle.setCategorie(new Categorie());
		article.setCategorie(new Categorie());
		article.setDesignation(new Designation());
		ArticleImpleService ArService = new ArticleImpleService();
		ArticleService = ArService.getArticleImplePort();
		motCle = "";
	}

	public String addArticle() {
		if (ArticleService.addArticle(article) != null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "bien ajouté"));
			return null;
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", " n'est pas ajouter"));
			return null;
		}

	}

	public String deleteArticle(Article a) {
		if (ArticleService.deleteArticle(Integer.parseInt(a.getRef()))) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "bien supprimé"));
			return null;
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", " mal supprimer"));
			return null;
		}

	}

	public String updateArticle() {

		if (ArticleService.updateArticle(eligibleUpdateArticle) != null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successful", "bien mis a jour"));
			return "article.xhtml?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", " "));
			return null;
		}

	}

	public String chercherParMt() {
//		searchedList=new ArrayList<Article>();
//		System.out.println("motcle:"+motCle);
//		for(Article art:listAricle) {
//			
//			if(art.getDesignation().getNomDesignation().contains(motCle) ||
//				art.getMarque().contains(motCle)	
//					) {
//				System.out.println("am inside");
//				searchedList.add(art);
//			}
//		}
//		listAricle=searchedList;
		return null;
	}

	public List<Article> getListAricle() {
		return listAricle;
	}

	public void setListAricle(List<Article> listAricle) {
		this.listAricle = listAricle;
	}

	public Article getEligibleUpdateArticle() {
		return eligibleUpdateArticle;
	}

	public String setEligibleUpdateArticle(Article eligibleUpdateArticle) {

		this.eligibleUpdateArticle = eligibleUpdateArticle;
		return "updateArticle.xhtml?faces-redirect=true";
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		article.setPrix(prix + "");
		eligibleUpdateArticle.setPrix(prix + "");
		this.prix = prix;
	}

//	public int getQte() {
//		return qte;
//	}
//
//	public void setQte(int qte) {
//		article.setQuantite(qte+"");
//		eligibleUpdateArticle.setQuantite(qte+"");
//		this.qte = qte;
//	}
	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public List<Article> getSearchedList() {
		return searchedList;
	}

	public void setSearchedList(List<Article> searchedList) {
		this.searchedList = searchedList;
	}

}
