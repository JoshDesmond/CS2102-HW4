import java.util.LinkedList;

interface IEarthquakeProbs {
	/**
	 * Given a list of doubles representing sensor data, produces a list of
	 * reports indicating the highest frequency reading for each day in that
	 * month.
	 * 
	 * @param data
	 *            LinkedList of doubles in the form: {20151004, 200, 150, 175,
	 *            20151005, 0.002, 0.03, 20151007 ...}
	 * @param int representing month, number between 1 and 12.
	 * 
	 * @return List of {@link MaxHzReport} within the given month.
	 */
	LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month);
}