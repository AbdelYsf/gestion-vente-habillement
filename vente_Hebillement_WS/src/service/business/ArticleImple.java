package service.business;

import java.util.List;

import javax.jws.WebService;

import dal.DaoAchat;
import dal.DaoArticle;
import dal.DaoVente;
import model.Achat;
import model.Article;
import model.Credit;
import model.Vente;
import model.Versement;

@WebService(endpointInterface = "service.business.IArticle")
public class ArticleImple implements IArticle {

	@Override
	public Article addArticle(final Article a) {
		return DaoArticle.addArticle(a);

	}

	@Override
	public Article updateArticle(final Article a) {
		return DaoArticle.updateArticle(a);
	}

	@Override
	public boolean deleteArticle(final int id) {

		return DaoArticle.deleteArticle(id);
	}

	@Override
	public Article[] getAllArticles() {
		final List<Article> listA = DaoArticle.getAllArtciles();
		return listA.toArray(new Article[listA.size()]);
	}

	@Override
	public Achat addAchat(final Achat a) {
		DaoAchat.addAchat(a);
		return a;
	}

	@Override
	public Achat[] getAllAchats() {
		final List<Achat> listA = DaoAchat.getAllAchat();
		return listA.toArray(new Achat[listA.size()]);
	}

	@Override
	public Vente[] getAllVents() {
		final List<Vente> listv = DaoVente.getAllVentes();
		return listv.toArray(new Vente[listv.size()]);

	}

	@Override
	public Vente[] getAllVentsOfAclient(final String clientID) {
		final List<Vente> listv = DaoVente.getAllVentes(clientID);
		return listv.toArray(new Vente[listv.size()]);

	}

	@Override
	public Vente addVente(final Vente v) {
		return DaoVente.addVente(v);
	}

	@Override
	public int addCredit(final Credit credit) {
		return DaoVente.addCredit(credit);

	}

	@Override
	public boolean annulerVente(final Vente v) {
		return DaoVente.annulerVente(v);

	}

	@Override
	public boolean addVersement(final Versement v) {
		return DaoVente.addVersement(v);
	}

	@Override
	public Article[] getArticlesByMotcle(final String mc) {
		if (mc.isEmpty()) {
			final List<Article> list = DaoArticle.getAllArtciles();
			return list.toArray(new Article[list.size()]);
		}
		final List<Article> list = DaoArticle.getMatchedArticles(mc);
		return list.toArray(new Article[list.size()]);
	}

	@Override
	public Vente[] getVenteBymotcle(final String mc) {
		if (mc.isEmpty()) {
			final List<Vente> listv = DaoVente.getAllVentes();
			return listv.toArray(new Vente[listv.size()]);
		}
		final List<Vente> listv = DaoVente.getMatchedVentes(mc);

		return listv.toArray(new Vente[listv.size()]);
	}

	@Override
	public Achat[] getAchatBymotcle(final String mc) {
		if (mc.isEmpty()) {
			final List<Achat> listA = DaoAchat.getAllAchat();
			return listA.toArray(new Achat[listA.size()]);
		}
		final List<Achat> listA = DaoAchat.getMathedAchat(mc);

		return listA.toArray(new Achat[listA.size()]);
	}

	@Override
	public Vente[] getAllVentsAvcCredit() {
		final List<Vente> listv = DaoVente.getAllVentesAvecCrdit();
		return listv.toArray(new Vente[listv.size()]);
	}

	@Override
	public boolean echangerVente(final Vente ancienVent, final Vente nouveauVente) {
		return DaoVente.echanger(ancienVent, nouveauVente);
	}

	@Override
	public Article[] getNeededArticle() {
		final List<Article> listA = DaoArticle.getNeededArticles();
		return listA.toArray(new Article[listA.size()]);
	}

	@Override
	public double getTotalCreditParClient(final String clientId) {
		// TODO Auto-generated method stub
		return DaoVente.getTotalCreditParClient(clientId);
	}

	@Override
	public Credit[] getAllCreditParCredit(final String clientId) {
		final List<Credit> listA = DaoVente.getAllCreditParCredit(clientId);
		return listA.toArray(new Credit[listA.size()]);
	}

}
