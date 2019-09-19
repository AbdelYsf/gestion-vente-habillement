package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.DaoVente;
import model.Article;
import model.Client;
import model.Credit;
import model.Vente;

/**
 * Servlet implementation class testVente
 */
@WebServlet("/testVente")
public class testVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testVente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		Article a= new Article();
//		a.setRef("14");
//	//	Vente v = new Vente(0,4, "1/1/2017", 900.8, "vente", "espece", new Client("4", "ayoube", "1334343", "wislane"),a , new Credit(300.0, null, "1/1/2019"));
//		
//		DaoVente.addVente(v);
//		
//		response.getWriter().append("Served at: "+DaoVente.getAllVentes().size()).append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
