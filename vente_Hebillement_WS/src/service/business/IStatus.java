package service.business;

import javax.jws.WebMethod;
import javax.jws.WebService;

import model.State;
import model.Statistics;

@WebService
public interface IStatus {
	@WebMethod
	public State getAppStatus();

	@WebMethod
	public Statistics[] getVenteBymonths();

	@WebMethod
	public Statistics[] getVenteCountByArticle();

	@WebMethod
	public Statistics[] getVenteCountByArticleDate(String startDate, String endDate);

	@WebMethod
	public Statistics[] getVenteCountByCategory(String s);

	@WebMethod
	public Statistics[] getVenteCountByCategoryDate(String s, String startDate, String endDate);

	@WebMethod
	public Statistics[] getVenteCountByTaille();

	@WebMethod
	public Statistics[] getVenteCountByTailleDate(String startDate, String endDate);

	@WebMethod
	public Statistics[] getVenteCount(String startDate, String endDate);
}
