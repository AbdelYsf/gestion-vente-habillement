package model;

public class Client {
	private String id_client;
	private String nom_complet;
	private String tele;
	private String adresse;
	
	public Client(String id_client, String nom_complet, String tele, String adresse) {
		super();
		this.id_client = id_client;
		this.nom_complet = nom_complet;
		this.tele = tele;
		this.adresse = adresse;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId_client() {
		return id_client;
	}
	public void setId_client(String id_client) {
		this.id_client = id_client;
	}
	public String getNom_complet() {
		return nom_complet;
	}
	public void setNom_complet(String nom_complet) {
		this.nom_complet = nom_complet;
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
