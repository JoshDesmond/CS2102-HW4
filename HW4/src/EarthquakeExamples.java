import java.util.Arrays;
import java.util.LinkedList;

import tester.Tester;

class EarthquakeExamples {
	IEarthquakeProbs E;

	private LinkedList<Double> data = getSensorData();

	EarthquakeExamples(final IEarthquakeProbs E) {
		this.E = E;
	}

	boolean testFoo(final Tester t) {
		return t.checkExpect(E.dailyMaxForMonth(null, 0), null);
	}

	/*
	 * 20151004 200 150 175 20151005 0.002 0.03 20151007, 1, 3, 20151103, 2, 4,
	 * 20151104, .5, .4, .505,
	 */

	public static LinkedList<Double> getSensorData() {
		// @formatter:off
		final LinkedList<Double> data = new LinkedList<Double>(
				Arrays.asList(
						20150508., 100., // 100
						20150509., 100., // 100
						20151004., 200.0, 150.0, 185.0, // Biggest is 200
						20151005., 0.002, 0.03, //.03
						20151007., 1.0, 3.0, // 3
						20151102., 2., 5., // 5
						20151217., 6., 4. // 6
						));
		// @formatter:on

		return data;
	}
}