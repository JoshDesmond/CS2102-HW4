import java.util.LinkedList;

class BMI2 implements IBMIProbs {
	BMI2() {
	}

	@Override
	public BMISummary bmiReport(final LinkedList<PHR> phrs) {

		final BMISummaryFactory fact = new BMISummaryFactory();

		for (final PHR record : phrs) {
			// only calculate bmi once
			final Double bmi = record.getBMI();

			if (bmi < 18.5) {
				fact.addUnder(record);
			} else if (bmi < 25.0) {
				fact.addHealthy(record);
			} else if (bmi < 30.0) {
				fact.addOver(record);
			} else {
				fact.addObese(record);
			}
		}

		return fact.build();
	}

	/**
	 * Factory for the data class {@link BMISummary}
	 */
	public class BMISummaryFactory {

		private LinkedList<String> under;
		private LinkedList<String> healthy;
		private LinkedList<String> over;
		private LinkedList<String> obese;

		public BMISummaryFactory() {
			under = new LinkedList<String>();
			healthy = new LinkedList<String>();
			over = new LinkedList<String>();
			obese = new LinkedList<String>();
		}

		public BMISummaryFactory addUnder(final PHR record) {
			under.add(record.name);
			return this;
		}

		public BMISummaryFactory addHealthy(final PHR record) {
			healthy.add(record.name);
			return this;
		}

		public BMISummaryFactory addOver(final PHR record) {
			over.add(record.name);
			return this;
		}

		public BMISummaryFactory addObese(final PHR record) {
			obese.add(record.name);
			return this;
		}

		public BMISummary build() {
			return new BMISummary(under, healthy, over, obese);
		}
	}
}