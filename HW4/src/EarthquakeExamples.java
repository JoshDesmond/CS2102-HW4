import java.util.Arrays;
import java.util.LinkedList;

import tester.TestMethod;
import tester.Tester;

class EarthquakeExamples {
	IEarthquakeProbs E;

	private LinkedList<Double> data = getSensorData();

	EarthquakeExamples(final IEarthquakeProbs E) {
		this.E = E;
	}

	@TestMethod
	public boolean testEarthquake(final Tester t) {
		return t.checkExpect(E.dailyMaxForMonth(getSensorData(), 10),
				getOutputData10());
	}

	@TestMethod
	public boolean testEarthqueak2(final Tester t) {
		return t.checkExpect(E.dailyMaxForMonth(getSensorData(), 5),
				getOutputData5());
	}

	/**
	 * Get input data
	 */
	private static LinkedList<Double> getSensorData() {
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

	/**
	 * Get output data if the input to function is 10, or october
	 */
	private static LinkedList<MaxHzReport> getOutputData10() {
		final LinkedList<MaxHzReport> data = new LinkedList<MaxHzReport>();

		data.add(new MaxHzReport(04, 200.0));
		data.add(new MaxHzReport(05, 0.03));
		data.add(new MaxHzReport(07, 3.0));

		return data;
	}

	/**
	 * Get output data if the input to function is 5, or May
	 */
	private static LinkedList<MaxHzReport> getOutputData5() {
		final LinkedList<MaxHzReport> data = new LinkedList<MaxHzReport>();

		data.add(new MaxHzReport(8, 100.));
		data.add(new MaxHzReport(9, 100.));

		return data;
	}

	/*
	 * @TestMethod // remove this public boolean testIsOfTypeDate(Tester t) {
	 * return t.checkExpect(Earthquake2.isOfTypeDate(20150723.0)); }
	 * 
	 * @TestMethod // remove this public boolean testDateOf(Tester t) { return
	 * t.checkExpect(EarthquakeReportsByMonth.monthOfDate(20150623.0) == 06); }
	 * 
	 * @TestMethod // remove this public boolean testDateOf2(Tester t) { return
	 * t.checkExpect(EarthquakeReportsByMonth.monthOfDate(20151225.0) == 12); }
	 */
}