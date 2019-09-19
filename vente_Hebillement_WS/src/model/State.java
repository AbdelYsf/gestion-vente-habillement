package model;

import java.io.Serializable;

public class State implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double chifferDAffair;
	private double	totalCredi;
	private int countArticle;
	private int countClient;
	private int countVente;
	private int countAchat;
	
	
	
	public int getCountVente() {
		return countVente;
	}
	public void setCountVente(int countVente) {
		this.countVente = countVente;
	}
	public int getCountAchat() {
		return countAchat;
	}
	public void setCountAchat(int countAchat) {
		this.countAchat = countAchat;
	}
	public double getChifferDAffair() {
		return chifferDAffair;
	}
	public void setChifferDAffair(double chifferDAffair) {
		this.chifferDAffair = chifferDAffair;
	}
	public double getTotalCredi() {
		return totalCredi;
	}
	public void setTotalCredi(double totalCredi) {
		this.totalCredi = totalCredi;
	}
	public int getCountArticle() {
		return countArticle;
	}
	public void setCountArticle(int countArticle) {
		this.countArticle = countArticle;
	}
	public int getCountClient() {
		return countClient;
	}
	public void setCountClient(int countClient) {
		this.countClient = countClient;
	}

}
