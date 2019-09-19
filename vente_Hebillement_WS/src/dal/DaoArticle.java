package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Article;
import model.Categorie;
import model.Designation;

public class DaoArticle {
	private static Connection cnx;
	static {
		cnx = DBConnection.getConnection();
	}

	private static PreparedStatement prstm;

	public static Article addArticle(final Article a) {

		final String qryArticle = "select * from article where ref = (SELECT MAX(ref) from article)";

		int res = 0;
		try {

			final Statement stm = cnx.createStatement();
			final String query = "insert into article(ref,taille,prix,quantite,id_categorie,id_designation,marque) values(null,?,?,?,?,?,?);";
			prstm = cnx.prepareStatement(query);
			prstm.setString(1, a.getTaille());
			prstm.setString(2, a.getPrix());
			prstm.setInt(3, 0); // prstm.setString(3, a.getQuantite());
			prstm.setString(4, a.getCategorie().getId_categ());
			prstm.setString(5, a.getDesignation().getId_designation());
			prstm.setString(6, a.getMarque());
			res = prstm.executeUpdate();

			if (res == 1) {

				final ResultSet rs = stm.executeQuery(qryArticle);

				if (rs.next()) {
					final Article ar = new Article(rs.getString("ref"), rs.getString("marque"), rs.getString("taille"),
							rs.getString("prix"), rs.getInt("quantite") + "");
					ar.setCategorie(getCategorie(rs.getInt("id_categorie")));
					a.setDesignation(getDesignation(rs.getInt("id_designation")));
					return ar;
				}
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Article updateArticle(final Article a) {
		int rs = 0;
		try {

			final String query = "update article set taille=? ,prix=?,quantite=? ,id_categorie=? ,id_designation=?, marque=? where ref=?;";
			prstm = cnx.prepareStatement(query);
			prstm.setString(1, a.getTaille());
			prstm.setString(2, a.getPrix());
			prstm.setString(3, a.getQuantite());
			prstm.setString(4, a.getCategorie().getId_categ());
			prstm.setString(5, a.getDesignation().getId_designation());
			prstm.setString(6, a.getMarque());
			prstm.setString(7, a.getRef());
			rs = prstm.executeUpdate();
		} catch (final SQLException e) {

			e.printStackTrace();
		}
		if (rs == 1) {
			return a;
		} else {
			return null;
		}
	}

	public static boolean deleteArticle(final int id) {
		int rs = 0;
		try {
			final String query = "delete from article where ref=?;";
			prstm = cnx.prepareStatement(query);
			prstm.setInt(1, id);
			rs = prstm.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		if (rs == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static List<Article> getAllArtciles() {

		final List<Article> list = new ArrayList<Article>();
		try {

			final Statement stm = cnx.createStatement();
			final ResultSet rs = stm.executeQuery("select * from article;");
			Article a;
			while (rs.next()) {
				a = new Article(rs.getString("ref"), rs.getString("marque"), rs.getString("taille"),
						rs.getString("prix"), rs.getInt("quantite") + "");
				a.setCategorie(getCategorie(rs.getInt("id_categorie")));
				a.setDesignation(getDesignation(rs.getInt("id_designation")));
				list.add(a);
			}
		} catch (final SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public static Categorie getCategorie(final int id_cate) {
		Categorie cate = null;
		try {
			final Statement stm = cnx.createStatement();
			final ResultSet rs = stm.executeQuery("select * from categorie where id_categorie=" + id_cate + ";");

			if (rs.next()) {
				cate = new Categorie(rs.getInt("id_categorie") + "", rs.getString("nom_categ"),
						rs.getString("type_categ"), rs.getString("sex"));
			}

		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cate;

	}

	public static Designation getDesignation(final int id_gesignation) {

		Designation designation = null;
		try {
			final Statement stm = cnx.createStatement();
			final ResultSet rs = stm
					.executeQuery("select * from designation where id_designation=" + id_gesignation + ";");
			if (rs.next()) {
				designation = new Designation(rs.getInt("id_designation") + "", rs.getString("nom_designation"),
						rs.getString("type_designation"));
			}

		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return designation;

	}

	public static Article getArticle(final int id_article) {
		Article a = null;
		try {
			final Statement stm = cnx.createStatement();
			final ResultSet rs = stm.executeQuery("select * from article where ref=" + id_article + ";");
			if (rs.next()) {
				a = new Article(rs.getString("ref"), rs.getString("marque"), rs.getString("taille"),
						rs.getString("prix"), rs.getInt("quantite") + "");
				a.setCategorie(getCategorie(rs.getInt("id_categorie")));
				a.setDesignation(getDesignation(rs.getInt("id_designation")));
			}

		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return a;
	}

	public static List<Article> getMatchedArticles(final String motCle) {
		final List<Article> list = new ArrayList<Article>();
		try {

			final Statement stm = cnx.createStatement();
			final ResultSet rs = stm.executeQuery("select * from article a , designation d, categorie c "
					+ " WHERE a.id_categorie=c.id_categorie and a.id_designation=d.id_designation "
					+ "having a.taille LIKE '" + motCle + "' or a.marque LIKE '" + motCle
					+ "' or d.nom_designation LIKE '" + motCle + "' or d.nom_designation LIKE'" + motCle
					+ "' OR c.nom_categ LIKE '" + motCle + "'OR c.type_categ LIKE '" + motCle + "' OR c.sex LIKE '"
					+ motCle + "' ;");
			Article a;
			while (rs.next()) {
				a = new Article(rs.getString("ref"), rs.getString("marque"), rs.getString("taille"),
						rs.getString("prix"), rs.getInt("quantite") + "");
				a.setCategorie(getCategorie(rs.getInt("id_categorie")));
				a.setDesignation(getDesignation(rs.getInt("id_designation")));
				list.add(a);
			}
		} catch (final SQLException e) {

			e.printStackTrace();
		}
		return list;

	}

	public static int getCountArticle() {
		try {
			final Statement stm = cnx.createStatement();
			final ResultSet rs = stm.executeQuery("select sum(quantite) from article;");
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public static List<Article> getNeededArticles() {
		final List<Article> list = new ArrayList<Article>();
		try {

			final Statement stm = cnx.createStatement();
			final ResultSet rs = stm.executeQuery("select * from article where quantite < 3");
			Article a;
			while (rs.next()) {
				a = new Article(rs.getString("ref"), rs.getString("marque"), rs.getString("taille"),
						rs.getString("prix"), rs.getInt("quantite") + "");
				a.setCategorie(getCategorie(rs.getInt("id_categorie")));
				a.setDesignation(getDesignation(rs.getInt("id_designation")));
				list.add(a);
			}
		} catch (final SQLException e) {

			e.printStackTrace();
		}
		return list;

	}

}
