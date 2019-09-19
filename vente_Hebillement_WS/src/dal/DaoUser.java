package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Admin;
import model.Client;
import model.Fournisseur;

public class DaoUser {
	private static Connection cnx;

	private static PreparedStatement prstm;
	static {
		cnx = DBConnection.getConnection();
	}

	public static boolean auth(Admin user) {
		
		
		boolean state = false;
		try {
			String query = "select * from admin where login=? and pwd=?;";
			prstm = cnx.prepareStatement(query);
			prstm.setString(1, user.getLogin());
			prstm.setString(2, user.getPwd());
			ResultSet rs = prstm.executeQuery();
			if (rs.next())
				state = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}

	public static Fournisseur addFournisseur(Fournisseur f) {

		int rs = 0;
		try {
			String query = "insert into fournisseur(id_fournisseur,nom,tele,adresse) values(null,?,?,?);";
			prstm = cnx.prepareStatement(query);
			prstm.setString(1, f.getNom());
			prstm.setString(2, f.getTele());
			prstm.setString(3, f.getAdresse());
			rs = prstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rs == 1)
			
			return f;
		else
			return null;
	}

	
	public static Fournisseur updateFournisseur(Fournisseur f) {
		int rs = 0;
		try {
			String query = "update fournisseur set nom=? ,tele=?,adresse=? where id_fournisseur=?;";
			prstm = cnx.prepareStatement(query);
			prstm.setString(1, f.getNom());
			prstm.setString(2, f.getTele());
			prstm.setString(3, f.getAdresse());
			prstm.setString(4, f.getId_fournisseur());
			rs = prstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rs == 1)
			return f;
		else
			return null;
	}

	public static boolean deleteFournisseur(int id) {
		int rs = 0;
		try {
			String query = "delete from fournisseur where id_fournisseur=? ;";
			prstm = cnx.prepareStatement(query);
			prstm.setInt(1, id);
			rs = prstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rs == 1)
			return true;
		else
			return false;
	}

	public static List<Fournisseur> getAllFournisseur() {

		List<Fournisseur> list = new ArrayList<Fournisseur>();
		try {
			Statement stm = cnx.createStatement();
			ResultSet rs = stm.executeQuery("select * from fournisseur;");

			Fournisseur f;
			while (rs.next()) {
				f = new Fournisseur(String.valueOf(rs.getInt("id_fournisseur")), rs.getString("nom"),
						rs.getString("tele"), rs.getString("adresse"));
				list.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static Client addClient(Client c) {

		int rs = 0;
		try {
			String query = "insert into client(id_client,nom,adresse,tele) values(null,?,?,?);" + "";
			prstm = cnx.prepareStatement(query);
			prstm.setString(1, c.getNom_complet());
			prstm.setString(2, c.getAdresse());
			prstm.setString(3, c.getTele());
			rs = prstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rs == 1)
			return c;
		else
			return null;
	}

	public static Client updateClient(Client c) {
		int rs = 0;
		try {
			String query = "update client set nom=? ,tele=?,adresse=? where id_client=?;";
			prstm = cnx.prepareStatement(query);
			prstm.setString(1, c.getNom_complet());
			prstm.setString(2, c.getTele());
			prstm.setString(3, c.getAdresse());
			prstm.setString(4, c.getId_client());
			rs = prstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rs == 1)
			return c;
		else
			return null;
	}

	public static boolean deleteClient(int id) {
		int rs = 0;
		try {
			String query = "delete from client where id_client=?;";
			prstm = cnx.prepareStatement(query);

			prstm.setInt(1, id);
			rs = prstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rs == 1)
			return true;
		else
			return false;
	}

	public static List<Client> getAllClients() {

		List<Client> list = new ArrayList<Client>();
		try {
			Statement stm = cnx.createStatement();
			ResultSet rs = stm.executeQuery("select * from client;");

			Client c;
			while (rs.next()) {
				c = new Client(String.valueOf(rs.getInt("id_client")), rs.getString("nom"), rs.getString("tele"),
						rs.getString("adresse"));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static Fournisseur getFournisseur(int id_fournisseur) {
		Fournisseur f = null;
		try {
			Statement stm = cnx.createStatement();
			ResultSet rs = stm.executeQuery("select * from fournisseur where id_fournisseur=" + id_fournisseur + ";");
			if (rs.next()) {
				f = new Fournisseur(String.valueOf(rs.getInt("id_fournisseur")), rs.getString("nom"),
						rs.getString("tele"), rs.getString("adresse"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	public static Client getClient(int id_client) {
		Client c = null;
		try {
			Statement stm = cnx.createStatement();
			ResultSet rs = stm.executeQuery("select * from client where id_client=" + id_client + ";");
			if (rs.next()) {
				c = new Client(String.valueOf(rs.getInt("id_client")), rs.getString("nom"), rs.getString("tele"),
						rs.getString("adresse"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return c;
	}
	public static List<Fournisseur> getMatchedFournisseur(String mc) {

		List<Fournisseur> list = new ArrayList<Fournisseur>();
		try {
			Statement stm = cnx.createStatement();
			ResultSet rs = stm.executeQuery("select * from fournisseur where nom like '"+mc+"' or tele LIKE '"+mc+"' or adresse LIKE '"+mc+"';");

			Fournisseur f;
			while (rs.next()) {
				f = new Fournisseur(String.valueOf(rs.getInt("id_fournisseur")), rs.getString("nom"),
						rs.getString("tele"), rs.getString("adresse"));
				list.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static List<Client> getMatchedClients(String mc) {

		List<Client> list = new ArrayList<Client>();
		try {
			Statement stm = cnx.createStatement();
			ResultSet rs = stm.executeQuery("select * from client where nom like '"+mc+"' or adresse like '"+mc+"'or tele like '"+mc+"' or id_client like '"+mc+"';");

			Client c;
			while (rs.next()) {
				c = new Client(String.valueOf(rs.getInt("id_client")), rs.getString("nom"), rs.getString("tele"),
						rs.getString("adresse"));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static int getCountClient() {
		try {
			Statement stm= cnx.createStatement();
			ResultSet rs=stm.executeQuery("select count(*) from client ;");
			if(rs.next())
			return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	

}
