package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Achat;

public class DaoAchat {
	private static Connection cnx;
	static {
		cnx =DBConnection.getConnection();
		System.out.println(cnx);
	}

	private static PreparedStatement prstm;
	public static boolean addAchat(Achat a) {
		int rs = 0;
		try {
			
			String query = "insert into achat(id_article,id_fournisseur,date_achat,quantite) values(?,?,?,?);";
			prstm = cnx.prepareStatement(query);
			prstm.setInt(1, Integer.parseInt(a.getArticle().getRef()));
			prstm.setInt(2, Integer.parseInt(a.getFournisseur().getId_fournisseur()));
			prstm.setString(3,a.getDate());
			prstm.setLong(4,a.getQuantite());
			rs = prstm.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		if (rs == 1){
			updateArticleQte(Integer.parseInt(a.getArticle().getRef()),a.getQuantite());
			return true;
			}
		else
			return false;
	}
	private static boolean updateArticleQte(int idArticle,int addedQte) {
		int rs = 0;
		try {
			String query = "update article set quantite = quantite+ ? where ref=? ";
			prstm = cnx.prepareStatement(query);
			prstm.setInt(2, idArticle);
			prstm.setInt(1, addedQte);
			rs = prstm.executeUpdate();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		if (rs == 1)
			return true;
		else
			return false;
	}
	public static List<Achat> getAllAchat(){

		List<Achat> list= new ArrayList<Achat>();
		try {
		
		Statement stm=cnx.createStatement();
		ResultSet rs=stm.executeQuery("select * from achat;");
		Achat a;
		while(rs.next()) {
				a= new Achat(rs.getInt("id_achat"),rs.getString("date_achat"), rs.getInt("quantite"));
						a.setFournisseur(DaoUser.getFournisseur(rs.getInt("id_fournisseur")));
						a.setArticle(DaoArticle.getArticle(rs.getInt("id_article")));
				list.add(a);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}

	public static List<Achat> getMathedAchat(String mc){

		List<Achat> list= new ArrayList<Achat>();
		try {
		
		Statement stm=cnx.createStatement();
		ResultSet rs=stm.executeQuery("select * from achat,fournisseur " + 
				"where achat.id_fournisseur=fournisseur.id_fournisseur " + 
				"having  date_achat LIKE '"+mc+"' or " + 
				"quantite like '"+mc+"' or " + 
				"fournisseur.nom LIKE '"+mc+"' or " + 
				"fournisseur.adresse LIKE '"+mc+"' or fournisseur.tele like '"+mc+"';");
		Achat a;
		System.out.println("am out rs");

		while(rs.next()) {
			System.out.println("am inside rs");
				a= new Achat(rs.getInt("id_achat"),rs.getString("date_achat"), rs.getInt("quantite"));
						a.setFournisseur(DaoUser.getFournisseur(rs.getInt("id_fournisseur")));
						a.setArticle(DaoArticle.getArticle(rs.getInt("id_article")));
				list.add(a);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	public static int getCountAchat() {
		int countV=0;
		try {
			Statement stm= cnx.createStatement();
			ResultSet rs= stm.executeQuery("select count(*) as countA from achat;");
			rs.next();
			countV= rs.getInt("countA");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countV;
		 
	}
	
}
