package model;

import java.util.ArrayList;

public class Credit {
	private double montant_credit;
	private ArrayList<Versement> versements;
	private String date_expiration;
	private int idCredit;
	private double montantPaye;
	private String etat;
	private double montantReste;
	

	public Credit() {
		super();
		// TODO Auto-generated constructor stub
	}
	




	
	

	public Credit(double montant_credit, ArrayList<Versement> versements, String date_expiration, int idCredit,
			double montantPaye, String etat) {
		super();
		this.montant_credit = montant_credit;
		this.versements = versements;
		this.date_expiration = date_expiration;
		this.idCredit = idCredit;
		this.montantPaye = montantPaye;
		this.etat = etat;
	}








	public String getDate_expiration() {
		return date_expiration;
	}





	public void setDate_expiration(String date_expiration) {
		this.date_expiration = date_expiration;
	}





	public double getMontant_credit() {
		return montant_credit;
	}


	public void setMontant_credit(double montant_credit) {
		this.montant_credit = montant_credit;
	}


	public ArrayList<Versement> getVersement() {
		return versements;
	}
	public void setVersement(ArrayList<Versement> versement) {
		this.versements = versement;
	}

	public int getIdCredit() {
		return idCredit;
	}

	public void setIdCredit(int idCredit) {
		this.idCredit = idCredit;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}






	public double getMontantPaye() {
		return montantPaye;
	}






	public void setMontantPaye(double montantPaye) {
		this.montantPaye = montantPaye;
	}








	public double getMontantReste() {
		return montantReste;
	}








	public void setMontantReste(double montantReste) {
		this.montantReste = montantReste;
	}
	

}
