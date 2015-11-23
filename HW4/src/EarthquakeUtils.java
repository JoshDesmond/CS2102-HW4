

public class EarthquakeUtils {

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
	 * Converts a double in the form yyyymmdd to a integer representing month
	 */
	public static int monthOfDate(final Double d) {
		return (int) ((d % 10000) - (d % 100)) / 100;
	}

	/**
	 * Converts a double in the form yyyymmdd to a integer representing day
	 */
	public static int dayOfDate(final Double dataValue) {
		return (int) (dataValue % 100);
	}


}
