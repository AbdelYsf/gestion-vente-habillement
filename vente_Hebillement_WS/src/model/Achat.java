package model;


public class Achat {
	private int id_achat;
	private String date;
	private int quantite;
	private Fournisseur fournisseur;
	private Article article;
	public Achat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Achat(String date, int quantite, Fournisseur fournisseur, Article article) {
		super();
		this.date = date;
		this.quantite = quantite;
		this.fournisseur = fournisseur;
		this.article = article;
	}
	
	public Achat(int id_achat, String date, int quantite, Fournisseur fournisseur, Article article) {
		super();
		this.id_achat = id_achat;
		this.date = date;
		this.quantite = quantite;
		this.fournisseur = fournisseur;
		this.article = article;
	}
	public Achat(int id_achat,String date, int quantite) {
		super();
		this.id_achat = id_achat;
		this.date = date;
		this.quantite = quantite;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public int getId_achat() {
		return id_achat;
	}
	public void setId_achat(int id_achat) {
		this.id_achat = id_achat;
	}
	

}
