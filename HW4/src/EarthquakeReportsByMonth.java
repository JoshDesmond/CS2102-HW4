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
		int day = dayOfDate(dateDouble);
		int month = monthOfDate(dateDouble);

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
			throw new IllegalStateException(String.format("Map doesn't contain the given month (or key) %s", month));
		}
		this.get(month).add(maxReport);
	}

	// Builds map of integer -> list<report>
	public static EarthquakeReportsByMonth instantiateMap() {
		final EarthquakeReportsByMonth map = new EarthquakeReportsByMonth(12);
		for (int i = 1; i <= 12; i++) {
			map.put(i, new LinkedList<MaxHzReport>());
		}

		return map;
	}

	/**
	 * Converts a double in the form yyyymmdd to a integer representing month
	 */
	public static int monthOfDate(final Double d) {
		return (int) ((d % 10000) - (d % 100))/100;
	}

	/**
	 * Converts a double in the form yyyymmdd to a integer representing day
	 */
	public static int dayOfDate(final Double dataValue) {
		return (int) (dataValue % 100);
	}

	@Override
	public String toString() {
		return "EarthquakeReportsByMonth ["
				+ (super.toString() != null ? "toString()=" + super.toString()
						: "") + "]";
	}
}