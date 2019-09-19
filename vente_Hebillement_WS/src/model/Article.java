package model;

public class Article {
	private String ref;
	private String marque;
	private String taille;
	private String prix;
	private String  quantite;
	private Categorie categorie;
	private Designation designation;
	public Article() {
		super();
	}
	public Article(String ref, String marque, String taille, String prix, String quantite, Categorie categorie,
			Designation designation) {
		super();
		this.ref = ref;
		this.marque = marque;
		this.taille = taille;
		this.prix = prix;
		this.quantite = quantite;
		this.categorie = categorie;
		this.designation = designation;
	}
	public Article(String ref, String marque, String taille, String prix, String quantite) {
		super();
		this.ref = ref;
		this.marque = marque;
		this.taille = taille;
		this.prix = prix;
		this.quantite = quantite;
		
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getTaille() {
		return taille;
	}
	public void setTaille(String taille) {
		this.taille = taille;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public String getQuantite() {
		return quantite;
	}
	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Designation getDesignation() {
		return designation;
	}
	public void setDesignation(Designation designation) {
		this.designation = designation;
	}
	

}
