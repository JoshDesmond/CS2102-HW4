import java.util.HashMap;
import java.util.LinkedList;

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
	 * Assumes this map was created using {@link instantiateMap()}. Destroys the
	 * given list.
	 * 
	 * @param dailyData
	 *            LinkedList in the form of: {yyyymmdd, n1, n2, n3... }.
	 */
	public void processDailyData(LinkedList<Double> dailyData) {
		// Parse first value
		double dateDouble = dailyData.pop();
		int day = EarthquakeUtils.dayOfDate(dateDouble);
		int month = EarthquakeUtils.monthOfDate(dateDouble);

		// Find best
		double maxRead = 0.0;
		for (double read : dailyData) {
			if (read > maxRead) {
				maxRead = read;
			}
		}

		// Add maxReport to list
		MaxHzReport maxReport = new MaxHzReport(day, maxRead);
		if (!this.containsKey(month)) {
			throw new IllegalStateException(String.format(
					"Map doesn't contain the given month (or key) %s", month));
		}
		this.get(month).add(maxReport);
	}

	/**
	 * instantiates EarthquakeReportsByMonth with each month already having an
	 * empty LinkedList assigned to it.
	 * 
	 * @return new EarthquakeReportsByMonth
	 */
	public static EarthquakeReportsByMonth instantiateMap() {
		final EarthquakeReportsByMonth map = new EarthquakeReportsByMonth(12);
		for (int i = 1; i <= 12; i++) {
			map.put(i, new LinkedList<MaxHzReport>());
		}

		return map;
	}

	@Override
	public String toString() {
		return "EarthquakeReportsByMonth ["
				+ (super.toString() != null ? "toString()=" + super.toString()
						: "") + "]";
	}
}