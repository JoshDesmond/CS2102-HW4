import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

class Earthquake2 implements IEarthquakeProbs {
	Earthquake2() {
	}

	private Map<Integer, LinkedList<MaxHzReport>> reportsByMonth = instantiateMap();

	@Override
	public LinkedList<MaxHzReport> dailyMaxForMonth(
			final LinkedList<Double> data, final int month) {
		if (data.isEmpty()) {
			return new LinkedList<MaxHzReport>();
		}

		processData(data);
		return getMonthlyData(month);
	}

	private LinkedList<MaxHzReport> getMonthlyData(final int month) {
		return reportsByMonth.get(month);
	}

	private void processData(final LinkedList<Double> data) {
		// Go through data, building list for each month
		final ListIterator<Double> i = data.listIterator();
		LinkedList<Double> currentList = null;

		Double d;
		do {
			d = i.next();
			if (isOfTypeDate(d)) {
				currentList = new LinkedList<Double>();
				reportsByMonth.put(monthOfDate(d), currentList);
			}

			else if (isOfTypeFreq(d)) {
				currentList.add(d);
			}
		} while (i.hasNext());

	}

	private Integer monthOfDate(final Double d) {
		// TODO Auto-generated method stub
		return null;
	}

	// Builds map of integer -> list<report>
	private Map<Integer, LinkedList<MaxHzReport>> instantiateMap() {
		final HashMap<Integer, LinkedList<MaxHzReport>> map = new HashMap<Integer, LinkedList<MaxHzReport>>(
				12);
		for (int i = 1; i <= 12; i++) {
			map.put(i, new LinkedList<MaxHzReport>());
		}

		return map;
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