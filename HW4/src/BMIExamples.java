import java.util.Arrays;
import java.util.LinkedList;

import tester.Tester;

class BMIExamples {
	IBMIProbs B;

	BMIExamples(final IBMIProbs b) {
		this.B = b;
	}

	public static LinkedList<PHR> getRecords() {

		final PHR p1 = buildPHR("p1", 1.0, 1.0);
		final PHR p2 = buildPHR("p2", 18.4, 1.0);
		final PHR p3 = buildPHR("p3", 18.6, 1.0);
		final PHR p4 = buildPHR("p4", 50.0, 1.0);
		final PHR p5 = buildPHR("p5", 50.0, 1.0);

		return new LinkedList<PHR>(Arrays.asList(p1, p2, p3, p4, p5));
	}

	// Convenience constructor
	private static PHR buildPHR(final String name, final double weight,
			final double height) {
		return new PHR(name, height, weight, 120);
	}

	/**
	 * get list of BMIData: [p1,p2], [p3], [], [p4]
	 */
	private static BMISummary getBMIData() {
		// @formatter:off
		final LinkedList<String> under = new LinkedList<String>(Arrays.asList("p1", "p2"));
		final LinkedList<String> health = new LinkedList<String>(Arrays.asList("p3"));
		final LinkedList<String> over = new LinkedList<String>();
		final LinkedList<String> obese = new LinkedList<String>(Arrays.asList("p4", "p5"));
		// @formatter:off
		return new BMISummary(under, health, over, obese);
	}

	/**
	 * Test function using all of the data retrieved from this class.
	 */
	boolean testBMI1(final Tester t) {
		return t.checkExpect(B.bmiReport(getRecords()),getBMIData());
	}

	/**
	 * Slight Modification to above test. Also more of an integration test.
	 */
	boolean testBMI2(final Tester t) {
		final LinkedList<PHR> in = getRecords();
		final BMISummary out = getBMIData();

		final PHR p = buildPHR("p",100.1,2.0);
		in.add(p);
		out.over.add("p");

		// check for failure
		if (!t.checkExpect(B.bmiReport(in),out))
			return t.fail();

		// then modify data, to ensure that bmiReport isn't modifying any of my lists.
		in.remove(p);
		out.over.remove("p");

		return t.checkExpect(B.bmiReport(in),out);

	}

}