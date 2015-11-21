import java.util.LinkedList;

class BMI1 implements IBMIProbs {
	BMI1() {
	}

	@Override
	/*
	 * (non-Javadoc)
	 * This implementation works like so: First the
	 * @see IBMIProbs#bmiReport(java.util.LinkedList)
	 */
	public BMISummary bmiReport(final LinkedList<PHR> phrs) {
		if (phrs == null) { // Argument validation
			throw new IllegalArgumentException("phrs was null");
		}

		final LinkedList<String> healthy = new LinkedList<String>();
		final LinkedList<String> underweight = new LinkedList<String>();
		final LinkedList<String> overweight = new LinkedList<String>();
		final LinkedList<String> obese = new LinkedList<String>();

		for (final PHR report : phrs) {
			switch (getBMIClass(report.getBMI())) {
			case UNDERWEIGHT:
				underweight.add(report.name);
				break;
			case HEALTHY:
				healthy.add(report.name);
				break;
			case OVERWEIGHT:
				overweight.add(report.name);
				break;
			case OBESE:
				obese.add(report.name);
				break;
			default:
				throw new IllegalArgumentException("Unreachable code in enum");
			}
		}

		return new BMISummary(underweight, healthy, overweight, obese);
	}

	/**
	 * Enum representing different classes of BMI health. Use
	 * {@link getBMIClass} to convert from a double to a BMIScale.
	 */
	public enum BMIScale {
		UNDERWEIGHT(0.0, 18.5), HEALTHY(18.5, 25.0), OVERWEIGHT(25.0, 30.0), OBESE(
				30.0, Double.MAX_VALUE);

		private double lowerBound;
		private double upperBound;

		BMIScale(final double lowerBound, final double upperBound) {
			this.lowerBound = lowerBound;
			this.upperBound = upperBound;
		}
	}

	/**
	 * Returns the {@link BMIScale} which the given double falls between.
	 * 
	 * @param bmi
	 *            a positive double representing BMI
	 * @return one of the classes of weight within BMIScale
	 */
	public static BMIScale getBMIClass(final Double bmi) {
		for (final BMIScale bmiClass : BMIScale.values()) {
			if (bmiClass.lowerBound <= bmi && bmi < bmiClass.upperBound) {
				return bmiClass;
			}
		}

		throw new IllegalArgumentException(String.format(
				"BMI value of %s given that was not in the range of BMIScale",
				bmi));
	}
}