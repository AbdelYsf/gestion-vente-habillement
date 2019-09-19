package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TestFournisseur
 */
@WebServlet("/TestFournisseur")
public class TestFournisseur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestFournisseur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//DaoAdmin.addFournisseur(new Fournisseur("1", "zara ", "89098880", "meknes,2114,hemria"));
		//Fournisseur f=DaoAdmin.updateFournisseur(new Fournisseur("1", "zara ", "89098880", "meknes,234,hemria"));
		//DaoAdmin.deleteFournisseur("1");
		//DaoAdmin.getAllFournisseur().size();
//DaoAdmin.addClient(new Client("", "mohamed", "2345678", "khemissate"));
//DaoAdmin.deleteClient("1");
		//DaoAdmin.updateClient(new Client("1", "mohamed", "1334343", "khmisssate"));
		
	//Categorie c = new Categorie("1", "adulte", "classique", "homme");
	//Designation d = new Designation("2", "Pantalon", "Tissu classique");
	//Article a = new Article("4", "zara", "xl", "130", "15", c, d);
	
	//DaoArticle.addArticle(a);
	//DaoArticle.getAllArtciles().size();	
//DaoAchat.addAchat(new Achat("3/7/2012", 45, new Fournisseur("2", "zara ", "89098880", "meknes,2114,hemria"), a));
	//DaoAchat.getAllArtciles().size();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
