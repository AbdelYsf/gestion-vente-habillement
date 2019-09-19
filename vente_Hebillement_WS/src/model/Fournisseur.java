package model;

public class Fournisseur {
	private String id_fournisseur;
	private String nom;
	private String tele;
	private String adresse;
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Fournisseur(String id_fournisseur, String nom, String tele, String adresse) {
		super();
		this.id_fournisseur = id_fournisseur;
		this.nom = nom;
		this.tele = tele;
		this.adresse = adresse;
	}
	public String getId_fournisseur() {
		return id_fournisseur;
	}
	public void setId_fournisseur(String id_fournisseur) {
		this.id_fournisseur = id_fournisseur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	

}
