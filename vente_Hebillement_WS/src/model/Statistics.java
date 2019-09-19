package model;

import java.io.Serializable;

public class Statistics implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nbrVente;
	private String categorie;
	private String taille;
	private String mois;
	private String article;
	private String dateVente;

	public int getNbrVente() {
		return nbrVente;
	}

	public Statistics(final int nbrVente, final String mois) {
		super();
		this.nbrVente = nbrVente;
		this.mois = mois;
	}

	public Statistics() {
		// TODO Auto-generated constructor stub
	}

	public void setNbrVente(final int nbrVente) {
		this.nbrVente = nbrVente;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(final String categorie) {
		this.categorie = categorie;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(final String taille) {
		this.taille = taille;
	}

	public String getMois() {
		return mois;
	}

	public void setMois(final String mois) {
		this.mois = mois;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(final String article) {
		this.article = article;
	}

	public String getDateVente() {
		return dateVente;
	}

	public void setDateVente(final String dateVente) {
		this.dateVente = dateVente;
	}

}
