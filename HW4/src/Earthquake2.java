import java.util.LinkedList;

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
		EarthquakeReportsByMonth reportsByMonth = EarthquakeReportsByMonth
				.instantiateMap();

		// split data in days.
		LinkedList<LinkedList<Double>> splitData = splitLists(sensorData);

		// Then, for each day, add it to the growing reportsByMonth.
		for (LinkedList<Double> dailyReadings : splitData) {
			reportsByMonth.processDailyData(dailyReadings);
		}

		// Return data.
		return reportsByMonth;
	}

	/**
	 * Converts raw sensor data into split data
	 * 
	 * @return Builds lists of daily reading lists. Each list within total list
	 *         will begin with a date.
	 */
	private LinkedList<LinkedList<Double>> splitLists(
			LinkedList<Double> sensorData) {
		// Set up iterator
		LinkedList<LinkedList<Double>> splitList = new LinkedList<LinkedList<Double>>();
		LinkedList<Double> currentList = new LinkedList<Double>();

		currentList.add(sensorData.pop());

		while (!sensorData.isEmpty()) {
			Double peek = sensorData.peek();

			if (isOfTypeDate(peek)) {
				// Then terminate currentList and start anew.
				splitList.add(currentList);
				currentList = new LinkedList<Double>();
			} else if (!isOfTypeFreq(peek)) {
				throw new IllegalArgumentException(String.format(
						"Given argument within sensor data list was neither of type "
								+ "frequency nor date: %s", peek));
			}

			currentList.add(sensorData.pop());
		}

		splitList.add(currentList);
		return splitList;
	}

	/**
	 * Parses given double and determines if it's a y-m-d string
	 * 
	 * @param sensorValue
	 *            double found in the sensor output
	 * @return true if the double is in the form yyyymmdd
	 */
	public static boolean isOfTypeDate(final Double sensorValue) {

		if (sensorValue % 1 != 0)
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
	public static boolean isOfTypeFreq(final double sensorValue) {
		return ((0.0 <= sensorValue) || (sensorValue <= 500.0));
	}

}