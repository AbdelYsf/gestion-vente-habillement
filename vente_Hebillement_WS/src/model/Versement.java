package model;

import java.util.Date;

public class Versement {
	private String  id_versement;
	private String date_versement ;
	private double mantant_versement;
	private int id_credit;
	public int getId_credit() {
		return id_credit;
	}
	public void setId_credit(int id_credit) {
		this.id_credit = id_credit;
	}
	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Versement(String id_versement, String date_versement, double mantant_versement) {
		super();
		this.id_versement = id_versement;
		this.date_versement = date_versement;
		this.mantant_versement = mantant_versement;
	}
	public String getId_versement() {
		return id_versement;
	}
	public void setId_versement(String id_versement) {
		this.id_versement = id_versement;
	}
	public String getDate_versement() {
		return date_versement;
	}
	public void setDate_versement(String date_versement) {
		this.date_versement = date_versement;
	}
	public double getMantant_versement() {
		return mantant_versement;
	}
	public void setMantant_versement(double mantant_versement) {
		this.mantant_versement = mantant_versement;
	}
	
}
