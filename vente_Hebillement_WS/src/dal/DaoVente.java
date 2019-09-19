package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Credit;
import model.Statistics;
import model.Vente;
import model.Versement;

public class DaoVente {
	private static Connection cnx;
	private static PreparedStatement prstm;

//	select sum(credit.montant),client.nom,SUM(credit.montant_paye) from credit,vente,client where client.id_client=vente.id_client and vente.id_credit=credit.id_credit GROUP BY client.nom;
	static {
		cnx = DBConnection.getConnection();

		System.out.println(cnx);
	}

	public static Vente addVente(final Vente v) {

		int rs = 0;
		try {

			final String query = "insert into vente(quantite,type_operation,montant,date_vente,id_article,id_client,id_credit,mode_payement) values(?,?,?,?,?,?,?,?)";
			final String queryUpdate = " update article set quantite= quantite - ? where ref=?; ";
			prstm = cnx.prepareStatement(query);
			prstm.setInt(1, v.getQuantite());
			prstm.setString(2, v.getType_operation());
			prstm.setDouble(3, v.getMantant());
			prstm.setString(4, v.getDate_vente());
			prstm.setInt(5, Integer.parseInt(v.getArticle().getRef()));
			prstm.setInt(6, Integer.parseInt(v.getClient().getId_client()));
			prstm.setInt(7, v.getCredit().getIdCredit());
			prstm.setString(8, v.getMode_payement());

			rs = prstm.executeUpdate();
			// update la quantité d'article;
			prstm = cnx.prepareStatement(queryUpdate);
			prstm.setInt(1, v.getQuantite());
			prstm.setInt(2, Integer.parseInt(v.getArticle().getRef()));
			prstm.executeUpdate();

		} catch (final SQLException e) {
			e.printStackTrace();
		}
		if (rs == 1) {
			return v;
		} else {
			return null;
		}
	}

	public static List<Vente> getAllVentes() {
		final List<Vente> listVente = new ArrayList<Vente>();
		try {
//select count(*) ,date_vente from vente where STR_TO_DATE(date_vente,'%m/%d/%Y') BETWEEN STR_TO_DATE("02/01/2019",'%m/%d/%Y') and STR_TO_DATE("02/19/2019",'%m/%d/%Y') group by date_vente;
			final String query = "select * from vente order by id_vente desc;";
			prstm = cnx.prepareStatement(query);
			final ResultSet rs = prstm.executeQuery();
			Vente v;

			while (rs.next()) {
				v = new Vente(rs.getInt("id_vente"), rs.getInt("quantite"), rs.getString("date_vente"),
						rs.getDouble("montant"), rs.getString("type_operation"), rs.getString("mode_payement"),
						DaoUser.getClient(rs.getInt("id_client")), DaoArticle.getArticle(rs.getInt("id_article")),
						getCredit(rs.getInt("id_credit")));
				listVente.add(v);
			}

		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return listVente;

	}

	public static List<Vente> getAllVentes(final String clientId) {
		final List<Vente> listVente = new ArrayList<Vente>();
		try {
//select count(*) ,date_vente from vente where STR_TO_DATE(date_vente,'%m/%d/%Y') BETWEEN STR_TO_DATE("02/01/2019",'%m/%d/%Y') and STR_TO_DATE("02/19/2019",'%m/%d/%Y') group by date_vente;
			final String query = "select * from vente  where id_client=" + clientId + " order by id_vente desc;";
			prstm = cnx.prepareStatement(query);
			final ResultSet rs = prstm.executeQuery();
			Vente v;

			while (rs.next()) {
				v = new Vente(rs.getInt("id_vente"), rs.getInt("quantite"), rs.getString("date_vente"),
						rs.getDouble("montant"), rs.getString("type_operation"), rs.getString("mode_payement"),
						DaoUser.getClient(rs.getInt("id_client")), DaoArticle.getArticle(rs.getInt("id_article")),
						getCredit(rs.getInt("id_credit")));
				listVente.add(v);
			}

		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return listVente;

	}

	public static List<Vente> getAllVentesAvecCrdit() {
		final List<Vente> listVente = new ArrayList<Vente>();
		try {

			final String query = "select * from vente where id_credit <> 0;";
			prstm = cnx.prepareStatement(query);
			final ResultSet rs = prstm.executeQuery();
			Vente v;

			while (rs.next()) {
				v = new Vente(rs.getInt("id_vente"), rs.getInt("quantite"), rs.getString("date_vente"),
						rs.getDouble("montant"), rs.getString("type_operation"), rs.getString("mode_payement"),
						DaoUser.getClient(rs.getInt("id_client")), DaoArticle.getArticle(rs.getInt("id_article")),
						getCredit(rs.getInt("id_credit")));
				listVente.add(v);
			}

		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return listVente;

	}

	public static int addCredit(final Credit c) {
		int pk = -1;
		try {
			final String query = "insert into credit(montant,date_expiration,montant_paye,etat) values (?,?,?,?);";

			prstm = cnx.prepareStatement(query);
			prstm.setDouble(1, c.getMontant_credit());
			prstm.setString(2, c.getDate_expiration());
			prstm.setDouble(3, 0);
			prstm.setString(4, "en cours");
			prstm.executeUpdate();
			prstm = cnx.prepareStatement("SELECT * FROM credit where id_credit =(select max(id_credit) from credit) ;");
			final ResultSet rs = prstm.executeQuery();
			if (rs.next()) {
				pk = rs.getInt("id_credit");// select max(id_credit) from credit;
			}
		} catch (final SQLException e) {

			e.printStackTrace();
		}
		return pk;

	}

	private static Credit getCredit(final int id) {
		final Credit c = new Credit();
		try {
			final Statement stm = cnx.createStatement();
			final ResultSet rs = stm.executeQuery("select * from credit where id_credit =" + id + ";");
			if (rs.next()) {
				c.setDate_expiration(rs.getString("date_expiration"));
				c.setMontant_credit(rs.getDouble("montant"));
				c.setIdCredit(rs.getInt("id_credit"));
				c.setMontantPaye(rs.getDouble("montant_paye"));
				c.setEtat(rs.getString("etat"));
				c.setMontantReste(c.getMontant_credit() - c.getMontantPaye());
				c.setVersement(getAllVresement(id));
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	//
	public static List<Credit> getAllCreditParCredit(final String clientId) {
		final Credit c;
		final List<Credit> listCredit = new ArrayList<>();
		try {
			final Statement stm = cnx.createStatement();
			final ResultSet rs = stm.executeQuery("select * from credit where id_credit =" + clientId + ";");
			if (rs.next()) {
				c = new Credit();
				c.setDate_expiration(rs.getString("date_expiration"));
				c.setMontant_credit(rs.getDouble("montant"));
				c.setIdCredit(rs.getInt("id_credit"));
				c.setMontantPaye(rs.getDouble("montant_paye"));
				c.setEtat(rs.getString("etat"));
				c.setMontantReste(c.getMontant_credit() - c.getMontantPaye());
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return listCredit;
	}

	public static boolean annulerVente(final Vente v) {
		int res = -1;
		final String queryUpdate = " update article set quantite= quantite + ? where ref=?; ";
		final String query = "delete from vente where id_vente= ?";
		final String deleteCredit = "delete from credit WHERE id_credit= ?;";
		try {

			// delete credit
			prstm = cnx.prepareStatement(deleteCredit);
			prstm.setInt(1, v.getCredit().getIdCredit());
			res = prstm.executeUpdate();
			//
			prstm = cnx.prepareStatement(query);
			prstm.setInt(1, v.getId_vente());
			res = prstm.executeUpdate();
			System.out.println("la res:" + res);
			// update la quantité d'article;
			prstm = cnx.prepareStatement(queryUpdate);
			System.out.println("prepared stm :" + prstm.toString());
			prstm.setInt(1, v.getQuantite());
			prstm.setInt(2, Integer.parseInt(v.getArticle().getRef()));
			prstm.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		if (res > 0) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean echanger(final Vente ancienVente, final Vente nouvelleVente) {

		final String qryUpdateQteOld = "update article set quantite= quantite + ";
		final String qryUpdateQteNew = "update article set quantite= quantite - ";
		final String qryUpdateCredit = " update credit set montant = ";

		final String queryUpdate = "update vente set id_article =?, type_operation=? ,montant=? where id_vente=? ;";
		try {
			prstm = cnx.prepareStatement(queryUpdate);
			prstm.setInt(1, Integer.parseInt(nouvelleVente.getArticle().getRef()));
			prstm.setString(2, "echange");
			prstm.setDouble(3, nouvelleVente.getMantant());
			prstm.setInt(4, ancienVente.getId_vente());
			final int rs1 = prstm.executeUpdate();
			if (rs1 == 1) {
				final Statement stm = cnx.createStatement();
				// System.out.println(qryUpdateQteNew+nouvelleVente.getQuantite()+" where ref=
				// "+nouvelleVente.getArticle().getRef()+";");
				stm.execute(qryUpdateQteNew + nouvelleVente.getQuantite() + " where ref= "
						+ nouvelleVente.getArticle().getRef());
				stm.execute(qryUpdateQteOld + ancienVente.getQuantite() + " where ref ="
						+ ancienVente.getArticle().getRef());
				// System.out.println(qryUpdateQteOld+ancienVente.getQuantite()+" where ref =
				// "+ancienVente.getArticle().getRef()+";");

				// update montant credit
				if (ancienVente.getCredit().getIdCredit() != 0) {
					System.out.println("updating crdit : " + ancienVente.getCredit().getIdCredit());
					stm.execute(qryUpdateCredit + nouvelleVente.getMantant() + " where id_credit = "
							+ ancienVente.getCredit().getIdCredit() + " ;");
				}
				return true;
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean addVersement(final Versement v) {
		int rs1 = 0;
		int rs2 = 0;
		final String query = "insert into versement(id_credit,date_versemnt,mantant) values (?,?,?);";
		final String updateQryCredit = "UPDATE credit set montant_paye = montant_paye + ? where id_credit = ?";
		try {

			prstm = cnx.prepareStatement(query);
			prstm.setInt(1, v.getId_credit());
			prstm.setString(2, v.getDate_versement());
			prstm.setDouble(3, v.getMantant_versement());
			rs1 = prstm.executeUpdate();

			// update le mt paye
			prstm = cnx.prepareStatement(updateQryCredit);
			prstm.setDouble(1, v.getMantant_versement());
			prstm.setInt(2, v.getId_credit());

			rs2 = prstm.executeUpdate();
			return true;
		} catch (final SQLException e) {

			e.printStackTrace();
		}
		if (rs1 == 1 && rs2 == 1) {
			return true;
		} else {
			return false;
		}

	}

	public static ArrayList<Versement> getAllVresement(final int id_credit) {
		final ArrayList<Versement> listersement = new ArrayList<Versement>();

		try {
			final Statement stm = cnx.createStatement();
			final ResultSet rs = stm.executeQuery("select * from versement where id_credit =" + id_credit + ";");
			Versement v;
			while (rs.next()) {

				v = new Versement();
				v.setDate_versement(rs.getString("date_versemnt"));
				v.setMantant_versement(rs.getDouble("mantant"));
				v.setId_versement(rs.getInt("id_versement") + "");
				v.setId_credit(id_credit);
				listersement.add(v);
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return listersement;
	}

	public static List<Vente> getMatchedVentes(final String mc) {
		final List<Vente> listVente = new ArrayList<Vente>();
		try {

			final String query = "select * from vente ,article ,client  where vente.id_client=client.id_client and vente.id_article=article.ref"
					+ " HAVING date_vente LIKE '" + mc + "' OR type_operation LIKE '" + mc + "' or mode_payement LIKE '"
					+ mc + "' or article.marque  LIKE '" + mc + "' or client.nom like '" + mc + "';";
			prstm = cnx.prepareStatement(query);
			final ResultSet rs = prstm.executeQuery();
			Vente v;

			while (rs.next()) {
				v = new Vente(rs.getInt("id_vente"), rs.getInt("quantite"), rs.getString("date_vente"),
						rs.getDouble("montant"), rs.getString("type_operation"), rs.getString("mode_payement"),
						DaoUser.getClient(rs.getInt("id_client")), DaoArticle.getArticle(rs.getInt("id_article")),
						getCredit(rs.getInt("id_credit")));
				listVente.add(v);
			}

		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return listVente;

	}

	public static double getChifferDaffaire() {
		try {
			final Statement stm = cnx.createStatement();
			final ResultSet rs = stm.executeQuery("select SUM(montant) as chiffreDaffaire from vente;");
			if (rs.next()) {
				return rs.getDouble("chiffreDaffaire");
			}

		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0;

	}

	public static double getTotalCredit() {
		double montantPaye = 0;
		double montanttotal = 0;
		try {
			final Statement stm = cnx.createStatement();
			final ResultSet rs = stm
					.executeQuery("select sum(montant_paye) as mt ,sum(montant) as totalCredit from credit;");
			rs.next();
			montantPaye = rs.getDouble("mt");
			montanttotal = rs.getDouble("totalCredit");
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		final double result = montanttotal - montantPaye;
		return result;

	}

	public static double getTotalCreditParClient(final String clientId) {
		double montantPaye = 0;
		double montanttotal = 0;
		try {
			final Statement stm = cnx.createStatement();
			final ResultSet rs = stm.executeQuery(
					"select sum(credit.montant_paye) as mt ,sum(credit.montant) as totalCredit from credit,client,vente\r\n"
							+ " where client.id_client=vente.id_client and vente.id_credit=credit.id_credit and client.id_client="
							+ clientId + ";");
			rs.next();
			montantPaye = rs.getDouble("mt");
			montanttotal = rs.getDouble("totalCredit");
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		final double result = montanttotal - montantPaye;
		return result;

	}

	public static int getCountVente() {
		int countV = 0;
		try {
			final Statement stm = cnx.createStatement();
			final ResultSet rs = stm.executeQuery("select count(*) as countV from vente;");
			rs.next();
			countV = rs.getInt("countV");

		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return countV;

	}
	// select substr( v.date_vente,1,2) as mois, date_vente, SUM(montant) from vente
	// as v group by mois;

	public static List<Statistics> getVenteByMonth() {
		final List<Statistics> listStatistics = new ArrayList<Statistics>();

		try {

			final String query = "select  substr( v.date_vente,1,2) as mois, date_vente, SUM(montant) as sumv from vente as v group by mois;";
			prstm = cnx.prepareStatement(query);
			final ResultSet rs = prstm.executeQuery();

			while (rs.next()) {
				System.out.println("inside while");
				System.out.println(rs.getString("mois"));
				if (rs.getString("mois").equals("01")) {
					listStatistics.add(new Statistics(rs.getInt("sumv"), "janvier"));
				} else if (rs.getString("mois").equals("02")) {
					listStatistics.add(new Statistics(rs.getInt("sumv"), "fevrier"));
				} else if (rs.getString("mois").equals("03")) {
					listStatistics.add(new Statistics(rs.getInt("sumv"), "mars"));
				} else if (rs.getString("mois").equals("04")) {
					listStatistics.add(new Statistics(rs.getInt("sumv"), "avril"));
				} else if (rs.getString("mois").equals("05")) {
					listStatistics.add(new Statistics(rs.getInt("sumv"), "may"));
				} else if (rs.getString("mois").equals("06")) {
					listStatistics.add(new Statistics(rs.getInt("sumv"), "juin"));
				} else if (rs.getString("mois").equals("07")) {
					listStatistics.add(new Statistics(rs.getInt("sumv"), "juille"));
				} else if (rs.getString("mois").equals("08")) {
					listStatistics.add(new Statistics(rs.getInt("sumv"), "aout"));
				} else if (rs.getString("mois").equals("09")) {
					listStatistics.add(new Statistics(rs.getInt("sumv"), "septembre"));
				} else if (rs.getString("mois").equals("10")) {
					listStatistics.add(new Statistics(rs.getInt("sumv"), "octobre"));
				} else if (rs.getString("mois").equals("11")) {
					listStatistics.add(new Statistics(rs.getInt("sumv"), "novembre"));
				} else if (rs.getString("mois").equals("12")) {
					listStatistics.add(new Statistics(rs.getInt("sumv"), "decembre"));
				}

			}

		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return listStatistics;

	}

	public static List<Statistics> getVenteCountByArticle() {

		final List<Statistics> listStatistics = new ArrayList<Statistics>();

		try {

			final String query = "select  count(*) as countv ,d.nom_designation as nomA from vente,article a,designation d where id_article = a.ref and a.id_designation=d.id_designation GROUP by d.nom_designation;";
			prstm = cnx.prepareStatement(query);
			final ResultSet rs = prstm.executeQuery();

			Statistics s;
			while (rs.next()) {
				s = new Statistics();
				s.setArticle(rs.getString("nomA"));
				s.setNbrVente(rs.getInt("countV"));
				listStatistics.add(s);
			}

		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return listStatistics;
	}

	public static List<Statistics> getVenteCountByArticle(final String startDate, final String endDate) {

		final List<Statistics> listStatistics = new ArrayList<Statistics>();

		try {

			final String query = "select  count(*) as countv ,d.nom_designation as nomA from vente,article a,designation d where id_article = a.ref and a.id_designation=d.id_designation and"
					+ " STR_TO_DATE(vente.date_vente, \"%m/%d/%Y\") BETWEEN " + "STR_TO_DATE('" + startDate
					+ "', \"%m/%d/%Y\") " + "and STR_TO_DATE('" + endDate + "', \"%m/%d/%Y\") "
					+ " GROUP by d.nom_designation;";

			prstm = cnx.prepareStatement(query);
			final ResultSet rs = prstm.executeQuery();

			Statistics s;
			while (rs.next()) {
				s = new Statistics();
				s.setArticle(rs.getString("nomA"));
				s.setNbrVente(rs.getInt("countV"));
				listStatistics.add(s);
			}

		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return listStatistics;
	}

	public static List<Statistics> getVenteCountByCategory(final String critere) {

		final List<Statistics> listStatistics = new ArrayList<Statistics>();

		try {
			final String query = "select count(*) as countV ,c.nom_categ,c.type_categ,c.sex from vente,article a,categorie c where id_article = a.ref and a.id_categorie= c.id_categorie GROUP by "
					+ critere + ";";
			prstm = cnx.prepareStatement(query);
			final ResultSet rs = prstm.executeQuery();
			Statistics s;
			while (rs.next()) {
				s = new Statistics();
				s.setCategorie(rs.getString(critere));
				s.setNbrVente(rs.getInt("countV"));
				listStatistics.add(s);
			}

		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return listStatistics;
	}

	public static List<Statistics> getVenteCountByTaille() {

		final List<Statistics> listStatistics = new ArrayList<Statistics>();

		try {
			final String query = "select sum(vente.quantite) as countV,taille from vente,article where vente.id_article = article.ref group by taille;";
			prstm = cnx.prepareStatement(query);
			final ResultSet rs = prstm.executeQuery();
			Statistics s;
			while (rs.next()) {
				s = new Statistics();
				s.setTaille(rs.getString("taille"));
				s.setNbrVente(rs.getInt("countV"));
				listStatistics.add(s);
			}

		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return listStatistics;
	}

	public static List<Statistics> getVenteCountByTaille(final String startDate, final String endDate) {

		final List<Statistics> listStatistics = new ArrayList<Statistics>();

		try {
			final String query = "select sum(vente.quantite) as countV,taille from vente,article where vente.id_article = article.ref "
					+ "and STR_TO_DATE(vente.date_vente, '%m/%d/%Y\')" + " BETWEEN STR_TO_DATE('" + startDate
					+ "', '%m/%d/%Y\')" + " and STR_TO_DATE('" + endDate + "', '%m/%d/%Y') group by taille";
			System.out.println(query);
			prstm = cnx.prepareStatement(query);
			final ResultSet rs = prstm.executeQuery();
			Statistics s;
			while (rs.next()) {
				s = new Statistics();
				s.setTaille(rs.getString("taille"));
				s.setNbrVente(rs.getInt("countV"));
				listStatistics.add(s);
			}

		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return listStatistics;
	}

	public static List<Statistics> getVenteCountByCategoryDate(final String critere, final String startDate,
			final String endDate) {
		final List<Statistics> listStatistics = new ArrayList<Statistics>();

		try {
			final String query = "select count(*) as countV ,c.nom_categ,c.type_categ,c.sex,v.date_vente from vente v,article a,categorie c where id_article = a.ref and a.id_categorie= c.id_categorie  and  STR_TO_DATE(v.date_vente,'%m/%d/%Y\') "
					+ " between STR_TO_DATE('" + startDate + "', '%m/%d/%Y\') and STR_TO_DATE('" + endDate
					+ "', '%m/%d/%Y\') group by " + critere + ";";
			System.out.println(query);
			prstm = cnx.prepareStatement(query);
			final ResultSet rs = prstm.executeQuery();
			Statistics s;
			while (rs.next()) {
				s = new Statistics();
				s.setCategorie(rs.getString(critere));
				s.setNbrVente(rs.getInt("countV"));
				listStatistics.add(s);
			}

		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return listStatistics;
	}

}
