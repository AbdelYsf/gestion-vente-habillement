package model;

public class Categorie {
	private String id_categ;
	private String nom_categ;
	private String type_categ;
	private String sex;
	public String getId_categ() {
		return id_categ;
	}
	public void setId_categ(String id_categ) {
		this.id_categ = id_categ;
	}
	public String getNom_categ() {
		return nom_categ;
	}
	public void setNom_categ(String nom_categ) {
		this.nom_categ = nom_categ;
	}
	public String getType_categ() {
		return type_categ;
	}
	public void setType_categ(String type_categ) {
		this.type_categ = type_categ;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categorie(String id_categ, String nom_categ, String type_categ, String sex) {
		super();
		this.id_categ = id_categ;
		this.nom_categ = nom_categ;
		this.type_categ = type_categ;
		this.sex = sex;
	}

}
