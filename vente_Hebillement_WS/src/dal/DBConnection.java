package dal;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnection {

	private static Connection con=null;
	private  DBConnection() {
		
	try {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("jdbc/gVente");
		con=ds.getConnection();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
		
	}
	
	public static Connection getConnection() {
		if(con==null) {
			new DBConnection();
		}
		return  con;
	}
	

}
