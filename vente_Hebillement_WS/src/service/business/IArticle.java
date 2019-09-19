package service.business;

import javax.jws.WebMethod;
import javax.jws.WebService;

import model.Achat;
import model.Article;
import model.Credit;
import model.Vente;
import model.Versement;

@WebService
public interface IArticle {
	@WebMethod
	public Article addArticle(Article a);

	@WebMethod
	public Article updateArticle(Article a);

	@WebMethod
	public boolean deleteArticle(int id);

	@WebMethod
	public Article[] getAllArticles();

	@WebMethod
	public Achat addAchat(Achat a);

	@WebMethod
	public Achat[] getAllAchats();

	@WebMethod
	public Vente[] getAllVents();

	@WebMethod
	public Vente[] getAllVentsOfAclient(String clientID);

	@WebMethod
	public Vente addVente(Vente v);

	@WebMethod
	public int addCredit(Credit credit);

	@WebMethod
	public boolean annulerVente(Vente v);

	@WebMethod
	public boolean addVersement(Versement v);

	@WebMethod
	public Article[] getArticlesByMotcle(String mc);

	@WebMethod
	public Vente[] getVenteBymotcle(String mc);

	@WebMethod
	public Achat[] getAchatBymotcle(String mc);

	@WebMethod
	public Vente[] getAllVentsAvcCredit();

	@WebMethod
	public boolean echangerVente(Vente ancienVent, Vente nouveauVente);

	@WebMethod
	public Article[] getNeededArticle();

	//
	@WebMethod
	public double getTotalCreditParClient(String clientId);

	@WebMethod
	public Credit[] getAllCreditParCredit(final String clientId);
}
