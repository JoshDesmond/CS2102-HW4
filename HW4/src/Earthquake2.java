import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Earthquake2 implements IEarthquakeProbs {
	Earthquake2() {
	}

	private Map<Integer, List<MaxHzReport>> reportsByMonth = instantiateMap();

	@Override
	public LinkedList<MaxHzReport> dailyMaxForMonth(final LinkedList<Double> data,
			final int month) {
		return null;
	}

	private Map<Integer, List<MaxHzReport>> instantiateMap() {
		final HashMap<Integer, List<MaxHzReport>> map = new HashMap<Integer, List<MaxHzReport>>(12);
		for (int i = 1; i <= 12; i++) {
			map.put(i, new LinkedList<MaxHzReport>());
		}

		return map;
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