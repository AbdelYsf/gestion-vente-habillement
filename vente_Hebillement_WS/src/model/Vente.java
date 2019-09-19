package model;


public class Vente {
	private int id_vente;
	private int quantite;
	private String date_vente;
	private double mantant;
	private String type_operation;
	private String mode_payement ;
	private Client client;
	private Article article;
	private Credit credit;
	
	



	public Vente(int id_vente, int quantite, String date_vente, double mantant, String type_operation,
			String mode_payement, Client client, Article article, Credit credit) {
		super();
		this.id_vente = id_vente;
		this.quantite = quantite;
		this.date_vente = date_vente;
		this.mantant = mantant;
		this.type_operation = type_operation;
		this.mode_payement = mode_payement;
		this.client = client;
		this.article = article;
		this.credit = credit;
	}

	public Vente() {
		super();
		
	}

	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getDate_vente() {
		return date_vente;
	}
	public void setDate_vente(String date_vente) {
		this.date_vente = date_vente;
	}
	public String getMode_payement() {
		return mode_payement;
	}
	public void setMode_payement(String mode_payement) {
		this.mode_payement = mode_payement;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}

	public Credit getCredit() {
		return credit;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}



	public String getType_operation() {
		return type_operation;
	}



	public void setType_operation(String type_operation) {
		this.type_operation = type_operation;
	}



	public double getMantant() {
		return mantant;
	}



	public void setMantant(double mantant) {
		this.mantant = mantant;
	}



	public int getId_vente() {
		return id_vente;
	}



	public void setId_vente(int id_vente) {
		this.id_vente = id_vente;
	}

	

}
