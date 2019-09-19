package model;

public class Admin {
	private String login;
	private String pwd;
	private String nom;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String login, String pwd, String nom) {
		super();
		this.login = login;
		this.pwd = pwd;
		this.nom = nom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	

}
