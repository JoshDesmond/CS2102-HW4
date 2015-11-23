import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This solution works by first creating a data structure which indexes all
 * MaxHzReports, then retrieving the MaxHz report for just the required month.
 * 
 * @author Josh Desmond
 */
class Earthquake2 implements IEarthquakeProbs {
	Earthquake2() {
	}

	@Override
	public LinkedList<MaxHzReport> dailyMaxForMonth(
			final LinkedList<Double> data, final int month) {

		if (data.isEmpty()) {
			return new LinkedList<MaxHzReport>();
		}

		EarthquakeReportsByMonth reportsByMonth = convertToReportsByMonthMap(data);
		return reportsByMonth.get(month);
	}

	/**
	 * Converts a sensorData list input to an indexed map of month ->
	 * MaxHzReport
	 * 
	 * @param sensorData
	 *            raw input data
	 * @return A Map of int month to MaxHzReports
	 */
	public EarthquakeReportsByMonth convertToReportsByMonthMap(
			final LinkedList<Double> sensorData) {
		// Instantiate reportsByMonth
		EarthquakeReportsByMonth reportsByMonth = EarthquakeReportsByMonth.instantiateMap();

		// First split data in days.
		LinkedList<LinkedList<Double>> splitData = splitLists(sensorData);

		// Then, for each day, add it to the growing reportsByMonth.
		for (LinkedList<Double> dailyReadings : splitData) {
			reportsByMonth.processDailyData(dailyReadings);
		}

		// Return data.
		return reportsByMonth;
	}

	private LinkedList<LinkedList<Double>> splitLists(
			LinkedList<Double> sensorData) {
		// Split data into list of lists, one list of doubles for each day.
		final ListIterator<Double> i = data.listIterator();
		LinkedList<Double> currentList;
	}



	/**
	 * Converts a double in the form yyyymmdd to a integer representing day
	 */
	private static int dayOfDate(final Double dataValue) {
		return (int) (dataValue % 100);
	}

	/**
	 * Parses given double and determines if it's a y-m-d string
	 * 
	 * @param sensorValue
	 *            double found in the sensor output
	 * @return true if the double is in the form yyyymmdd
	 */
	private static boolean isOfTypeDate(final Double sensorValue) {

		if (sensorValue % 1 == 0)
			return false;

		if (19000000 > sensorValue || sensorValue > 100000000) {
			// Assumes year will never be before 1900...
			return false;
		}

		if (sensorValue % 100 > 33)
			return false; // Check if the dd value is too big.

		return true;
	}

	/**
	 * Determines if the given double is a valid vibration freq between 0 and
	 * 500.
	 * 
	 * @param sensorValue
	 *            double found in the sensor output
	 * @return true if the double is in the form of a freq
	 */
	private static boolean isOfTypeFreq(final double sensorValue) {
		return ((0.0 <= sensorValue) || (sensorValue <= 500.0));
	}

}