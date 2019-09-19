package model;

public class Designation {
	private String id_designation;
	private String nom_designation;
	private String sous_Type;
	
	public Designation(String id_designation, String nom_designation, String sous_Type) {
		super();
		this.id_designation = id_designation;
		this.nom_designation = nom_designation;
		this.sous_Type = sous_Type;
	}
	public Designation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId_designation() {
		return id_designation;
	}
	public void setId_designation(String id_designation) {
		this.id_designation = id_designation;
	}
	public String getNom_designation() {
		return nom_designation;
	}
	public void setNom_designation(String nom_designation) {
		this.nom_designation = nom_designation;
	}
	public String getSous_Type() {
		return sous_Type;
	}
	public void setSous_Type(String sous_Type) {
		this.sous_Type = sous_Type;
	}

}
