package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

import model.Statistics;

public class StatisticsComparator implements Comparator<Statistics> {

	@Override
	public int compare(final Statistics o1, final Statistics o2) {

		Date d1 = null;
		Date d2 = null;
		try {
			d1 = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).parse(o1.getDateVente());
			d2 = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).parse(o2.getDateVente());
		} catch (final ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (d1.after(d2)) {
			return 1;
		} else if (d2.after(d1)) {
			return -1;
		} else {
			return 0;
		}
	}

}
