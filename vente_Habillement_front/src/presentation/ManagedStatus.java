package presentation;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import service.business.IStatus;
import service.business.State;
import service.business.Statistics;
import service.business.StatusImplService;

@ManagedBean
@SessionScoped
public class ManagedStatus {
	private final IStatus statusWS;
	private State etat;
	// private Statistics statistics;
	private LineChartModel lineModel1;
	private StreamedContent MonthlySalesChart;
	private StreamedContent ArticleSalesChart;
	private BarChartModel barModelTaille;
	private BarChartModel barModelSex;
	private BarChartModel barModelAge;
	private BarChartModel barModelType;

	public ManagedStatus() {
		super();
		final StatusImplService statusService = new StatusImplService();
		statusWS = statusService.getStatusImplPort();

	}

	public void init() {
		etat = statusWS.getAppStatus();
		chartByMonths();
		chartByArticle();
		createLineModels();
		initBarModelTaille();
		initBarModelSex();
		initBarModelAge();
		initBarModelType();
		// createLineModels();
	}

	private void createLineModels() {
		System.out.println("teeeest");
		lineModel1 = initLineModel();
		// lineModel1.setTitle("Linear Chart test");
		lineModel1.setLegendPosition("w");
		final Axis yAxis = lineModel1.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(10);

	}

	private LineChartModel initLineModel() {
		final LineChartModel model = new LineChartModel();
		final LineChartSeries series1 = new LineChartSeries();
		series1.setLabel("test");

		series1.set(1, 2);
		series1.set(2, 1);
		series1.set(3, 3);
		series1.set(4, 6);
		series1.set(5, 8);

		model.addSeries(series1);

		return model;
	}

	private void chartByMonths() {

		try {
			final JFreeChart jFreeChart2 = ChartFactory.createBarChart3D("le chiffre d'affaire par mois", "les mois",
					"le montant en MAD", createLineChartByMonths());
			// JFreeChart jFreeChart2 =ChartFactory.createLineChart3D("les vente par mois",
			// "les moins", "les vente", createLineChart());
			final File chartFileLine = new File("linechart");
			// jFreeChart2.getPlot().setBackgroundPaint( Color.blue);
			ChartUtilities.saveChartAsPNG(chartFileLine, jFreeChart2, 475, 400);
			final CategoryPlot cp = jFreeChart2.getCategoryPlot();
			cp.getRenderer().setSeriesPaint(0, Color.green);
			cp.getRenderer().setSeriesPaint(1, Color.blue);
			cp.getRenderer().setSeriesPaint(2, Color.red);
			cp.getRenderer().setSeriesPaint(3, Color.orange);

			MonthlySalesChart = new DefaultStreamedContent(new FileInputStream(chartFileLine));
		} catch (final IOException e) {
			e.printStackTrace();
		}

	}

	private CategoryDataset createLineChartByMonths() {

		final DefaultCategoryDataset cds = new DefaultCategoryDataset();
		final List<Statistics> list = statusWS.getVenteBymonths();
		list.forEach(e -> {
			System.out.println(e.getMois());
			cds.addValue(e.getNbrVente(), "les ventes", e.getMois());
		});
//		cds.addValue(234, "les vente", "ANNEE 1");
//		cds.addValue(123, "les vente", "ANNEE 2");
//		cds.addValue(211, "les vente", "ANNEE 3");

		return cds;
	}

	private void chartByArticle() {
		try {
			final JFreeChart jFreeChart = ChartFactory.createBarChart3D("les vente par chaque article", "les mois",
					"nomber des Ventes", createLineChartByArticle());
			final File chartFileLine = new File("linechartArticle");
			ChartUtilities.saveChartAsPNG(chartFileLine, jFreeChart, 900, 500);

			final CategoryPlot cp = jFreeChart.getCategoryPlot();
			((BarRenderer) cp.getRenderer()).setBarPainter(new StandardBarPainter());
			final BarRenderer r = (BarRenderer) jFreeChart.getCategoryPlot().getRenderer();
			r.setSeriesPaint(0, Color.green);

			cp.getRenderer().setSeriesPaint(0, Color.green);
			cp.getRenderer().setSeriesPaint(1, Color.blue);
			cp.getRenderer().setSeriesPaint(2, Color.red);
			cp.getRenderer().setSeriesPaint(3, Color.orange);

			setArticleSalesChart(new DefaultStreamedContent(new FileInputStream(chartFileLine)));
		} catch (final IOException e) {
			e.printStackTrace();
		}

	}

	private CategoryDataset createLineChartByArticle() {
		final DefaultCategoryDataset cds = new DefaultCategoryDataset();
		final List<Statistics> list = statusWS.getVenteCountByArticle();
		list.forEach(e -> {
			System.out.println(e.getArticle());
			cds.addValue(e.getNbrVente(), "les ventes", e.getArticle());
		});
//		

		return cds;
	}

	public State getEtat() {
		return etat;
	}

	public void setEtat(final State etat) {
		this.etat = etat;
	}

	public LineChartModel getLineModel1() {
		return lineModel1;
	}

	public void setLineModel1(final LineChartModel lineModel1) {
		this.lineModel1 = lineModel1;
	}

	public StreamedContent getMonthlySalesChart() {
		return MonthlySalesChart;
	}

	public void setMonthlySalesChart(final StreamedContent monthlySalesChart) {
		MonthlySalesChart = monthlySalesChart;
	}

	public StreamedContent getArticleSalesChart() {
		return ArticleSalesChart;
	}

	public void setArticleSalesChart(final StreamedContent articleSalesChart) {
		ArticleSalesChart = articleSalesChart;
	}

	//

	private BarChartModel initBarModelTaille() {
		final BarChartModel model = new BarChartModel();
		final List<Statistics> listS = statusWS.getVenteCountByTaille();
		final ChartSeries taille = new ChartSeries();
		taille.setLabel("les taille");
		String max = "0";
		for (final Statistics s : listS) {

			taille.set(s.getTaille(), s.getNbrVente());
			if (s.getNbrVente() > Integer.parseInt(max)) {
				max = s.getNbrVente() + "";
			}
		}
		model.addSeries(taille);
		barModelTaille = model;

		barModelTaille.setTitle("les ventes par taille");
		barModelTaille.setLegendPosition("e");

		// final Axis xAxis = barModelTaille.getAxis(AxisType.X);
		// xAxis.setLabel("les tailles");

		final Axis yAxis = barModelTaille.getAxis(AxisType.Y);
		yAxis.setLabel("nbr des ventes");
		yAxis.setMin(0);
		// yAxis.setTickInterval(String.valueOf(Integer.parseInt(max)/10));
		// yAxis.setMax(max);

		return model;
	}

	private void initBarModelSex() {
		final BarChartModel model = new BarChartModel();
		final List<Statistics> listS = statusWS.getVenteCountByCategory("c.sex");
		final ChartSeries sex = new ChartSeries();
		String max = "0";
		for (final Statistics s : listS) {

			sex.set(s.getCategorie(), s.getNbrVente());
			if (s.getNbrVente() > Integer.parseInt(max)) {
				max = s.getNbrVente() + "";
			}
		}
		model.addSeries(sex);
		barModelSex = model;

		barModelSex.setTitle("les ventes par sex");
		barModelSex.setLegendPosition("e");

		// final Axis xAxis = barModelSex.getAxis(AxisType.X);
		// xAxis.setLabel("les tailles");

		final Axis yAxis = barModelSex.getAxis(AxisType.Y);
		yAxis.setLabel("nbr des ventes");
		yAxis.setMin(0);

	}

	private void initBarModelAge() {
		final BarChartModel model = new BarChartModel();
		final List<Statistics> listS = statusWS.getVenteCountByCategory("c.nom_categ");
		final ChartSeries sex = new ChartSeries();
		sex.setLabel("les taille");
		String max = "0";
		for (final Statistics s : listS) {

			sex.set(s.getCategorie(), s.getNbrVente());
			if (s.getNbrVente() > Integer.parseInt(max)) {
				max = s.getNbrVente() + "";
			}
		}
		model.addSeries(sex);
		barModelAge = model;

		barModelAge.setTitle("les ventes par age");
		barModelAge.setLegendPosition("e");

//		final Axis xAxis = barModelAge.getAxis(AxisType.X);
		// xAxis.setLabel("les tailles");

		final Axis yAxis = barModelAge.getAxis(AxisType.Y);
		yAxis.setLabel("nbr des ventes");
		yAxis.setMin(0);

	}

	private void initBarModelType() {
		final BarChartModel model = new BarChartModel();
		final List<Statistics> listS = statusWS.getVenteCountByCategory("c.type_categ");
		final ChartSeries sex = new ChartSeries();
		String max = "0";
		for (final Statistics s : listS) {

			sex.set(s.getCategorie(), s.getNbrVente());
			if (s.getNbrVente() > Integer.parseInt(max)) {
				max = s.getNbrVente() + "";
			}
		}
		model.addSeries(sex);
		barModelType = model;

		barModelType.setTitle("les ventes par categorie");
		barModelType.setLegendPosition("e");

//		final Axis xAxis = barModelType.getAxis(AxisType.X);
		// xAxis.setLabel("les tailles");

		final Axis yAxis = barModelType.getAxis(AxisType.Y);
		yAxis.setLabel("nbr des ventes");
		yAxis.setMin(0);

	}
//	private void createBarModel() {
//        barModelTaille = initBarModel();
// 
//        barModelTaille.setTitle("le nomber de vente par taille");
//        barModelTaille.setLegendPosition("e");
// 
//        Axis xAxis = barModelTaille.getAxis(AxisType.X);
//        xAxis.setLabel("les tailles");
// 
//        Axis yAxis = barModelTaille.getAxis(AxisType.Y);
//        yAxis.setLabel("nbr des ventes");
//        yAxis.setMin(0);
//        yAxis.setTickInterval("4");
//        yAxis.setMax(6);
//    }
//	
//	

	public BarChartModel getBarModelTaille() {
		return barModelTaille;
	}

	public void setBarModelTaille(final BarChartModel barModelTaille) {
		this.barModelTaille = barModelTaille;
	}

	public BarChartModel getBarModelSex() {
		return barModelSex;
	}

	public void setBarModelSex(final BarChartModel barModelSex) {
		this.barModelSex = barModelSex;

	}

	public BarChartModel getBarModelAge() {
		return barModelAge;
	}

	public void setBarModelAge(final BarChartModel barModelAge) {
		this.barModelAge = barModelAge;
	}

	public BarChartModel getBarModelType() {
		return barModelType;
	}

	public void setBarModelType(final BarChartModel barModelType) {
		this.barModelType = barModelType;
	}
}
