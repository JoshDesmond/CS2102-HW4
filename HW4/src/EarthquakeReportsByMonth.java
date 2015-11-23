import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Map representing an indexed version of MaxHzReports
 */
public class EarthquakeReportsByMonth extends
HashMap<Integer, LinkedList<MaxHzReport>> {

	/**
	 * {@link HashMap#HashMap(int)}
	 */
	private EarthquakeReportsByMonth(int i) {
		super(i);
	}

	/**
	 * Processes the given dailyData list, and puts that data into this Map.
	 * Assumes this map was created using {@link instantiateMap()}
	 * 
	 * @param dailyData
	 *            LinkedList in the form of: {yyyymmdd, n1, n2, n3... }.
	 */
	public void processDailyData(List<Double> dailyData) {
		// TODO
	}

	// Builds map of integer -> list<report>
	public static EarthquakeReportsByMonth instantiateMap() {
		final EarthquakeReportsByMonth map = new EarthquakeReportsByMonth(12);
		for (int i = 1; i <= 12; i++) {
			map.put(i, new LinkedList<MaxHzReport>());
		}

		return map;
	}

	private int monthOfDate(final Double d) {
		return (int) ((d % 10000) - (d % 100));
	}
}