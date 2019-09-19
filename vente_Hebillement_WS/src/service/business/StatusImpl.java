package service.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;

import javax.jws.WebParam;
import javax.jws.WebService;

import dal.DaoAchat;
import dal.DaoArticle;
import dal.DaoUser;
import dal.DaoVente;
import model.State;
import model.Statistics;
import model.Vente;
import utilities.StatisticsComparator;

@WebService(endpointInterface = "service.business.IStatus")
public class StatusImpl implements IStatus {

	@Override
	public State getAppStatus() {
		final State state = new State();
		state.setChifferDAffair(DaoVente.getChifferDaffaire());
		state.setTotalCredi(DaoVente.getTotalCredit());
		state.setCountArticle(DaoArticle.getCountArticle());
		state.setCountClient(DaoUser.getCountClient());
		state.setCountAchat(DaoAchat.getCountAchat());
		state.setCountVente(DaoVente.getCountVente());
		return state;
	}

	@Override
	public Statistics[] getVenteBymonths() {
		final List<Statistics> list = DaoVente.getVenteByMonth();
		return list.toArray(new Statistics[list.size()]);
	}

	@Override
	public Statistics[] getVenteCountByArticle() {
		final List<Statistics> list = DaoVente.getVenteCountByArticle();
		return list.toArray(new Statistics[list.size()]);
	}

	@Override
	public Statistics[] getVenteCountByCategory(final String s) {
		final List<Statistics> list = DaoVente.getVenteCountByCategory(s);
		return list.toArray(new Statistics[list.size()]);
	}

	@Override
	public Statistics[] getVenteCountByTaille() {
		final List<Statistics> list = DaoVente.getVenteCountByTaille();
		return list.toArray(new Statistics[list.size()]);
	}

	@Override
	public Statistics[] getVenteCount(final String startDate, final String endDate) {
		final List<Vente> venteList = DaoVente.getAllVentes();
		final HashMap<String, Integer> result = new HashMap<String, Integer>();
		final List<Statistics> listStatistics = new ArrayList<Statistics>();
		Statistics s;

		try {

			final Date dateStart = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).parse(startDate);
			final Date dateEnd = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).parse(endDate);

			Date targetDate;

			for (final Vente v : venteList) {
				targetDate = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).parse(v.getDate_vente());

				if (targetDate.after(dateStart) && targetDate.before(dateEnd)) {
					if (result.containsKey(v.getDate_vente())) {
						result.put(v.getDate_vente(), result.get(v.getDate_vente()) + 1);

					} else {
						result.put(v.getDate_vente(), 1);
					}
					;
				}
			}

			for (final Entry<String, Integer> e : result.entrySet()) {
				s = new Statistics();
				s.setDateVente(e.getKey());
				s.setNbrVente(e.getValue());
				listStatistics.add(s);
			}

		} catch (

		final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.sort(listStatistics, new StatisticsComparator());
		return listStatistics.toArray(new Statistics[listStatistics.size()]);
	}

	@Override
	public Statistics[] getVenteCountByTailleDate(final String startDate, final String endDate) {

		final List<Statistics> listS = DaoVente.getVenteCountByTaille(startDate, endDate);
		for (final Statistics s : listS) {
			System.out.println(s.getTaille());
			System.out.println(s.getNbrVente());
		}
		System.out.println(listS.size());
		return listS.toArray(new Statistics[listS.size()]);
	}

	@Override
	public Statistics[] getVenteCountByArticleDate(final String startDate, final String endDate) {
		final List<Statistics> listA = DaoVente.getVenteCountByArticle(startDate, endDate);

		return listA.toArray(new Statistics[listA.size()]);
	}

	@Override
	public Statistics[] getVenteCountByCategoryDate(@WebParam(name = "critere") final String s,
			@WebParam(name = "startDate") final String startDate, @WebParam(name = "endDate") final String endDate) {
		System.out.println("hiiiiiiiiii");
		final List<Statistics> list = DaoVente.getVenteCountByCategoryDate(s, startDate, endDate);

		return list.toArray(new Statistics[list.size()]);
	}

}
