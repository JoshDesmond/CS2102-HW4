import java.util.LinkedList;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Earthquake1 implements IEarthquakeProbs {
	Earthquake1() {
	}

	private static Function<? super LinkedList<Double>, MaxHzReport> MAP_FUNCTION =
			(list -> {
				for (double d : list) {

				}
			})

			@Override
			public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data,
					int month) {

		// First split data.
		LinkedList<LinkedList<Double>> splitData = splitLists(data);
		// Then filter through and retrieve only data for given month.
		splitData = splitData.stream().filter(getPredicate(month))
				.collect(Collectors.toCollection(LinkedList::new));

		// Then convert these dailyDataLists into MaxHzReads.
		return splitData.stream().map(getMapFunction())
				.collect(Collectors.toCollection(LinkedList::new));
	}

	private Function<? super LinkedList<Double>, MaxHzReport> getMapFunction() {
		// TODO Auto-generated method stub
		return null;
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

			if (EarthquakeUtils.isOfTypeDate(peek)) {
				// Then terminate currentList and start anew.
				splitList.add(currentList);
				currentList = new LinkedList<Double>();
			} else if (!EarthquakeUtils.isOfTypeFreq(peek)) {
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
	 * Returns a predicate which determines which month this parsed data belongs
	 * to.
	 * 
	 * @param month
	 *            int between 1 and 12 inclusive
	 * @return Predicate function of (LinkedList<Double> -> boolean).
	 */
	public static Predicate<? super LinkedList<Double>> getPredicate(int month) {
		if (0 >= month || 12 < month) {
			throw new IllegalArgumentException(String.format(
					"Given month is not valid %s", month));
		}

		Predicate<? super LinkedList<Double>> func = (list -> EarthquakeUtils
				.monthOfDate(list.peek()) == month);

		return func;
	}

}
