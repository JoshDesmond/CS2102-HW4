import java.util.LinkedList;
import java.util.stream.Collectors;

class BMI2 implements IBMIProbs {
	BMI2(){}

	/**
	 * Gives back BMI summary for the given list of PHR
	 * @param phrs
	 *            a list of personal health records
	 * @return
     */
	@Override
	public BMISummary bmiReport(final LinkedList<PHR> phrs) {

		// create 4 lists, one for each category
		final LinkedList<String> under = filterUnderWeight(phrs);
		final LinkedList<String>  healthy = filterHealthy(phrs);
		final LinkedList<String> overweight = filterOver(phrs);
		final LinkedList<String> obese = filterObese(phrs);

		return new BMISummary(under, healthy, overweight, obese);
	}

	/**
	 * gives back list of obese
	 * @param phrs
	 * @return
     */
	private LinkedList<String> filterObese(final LinkedList<PHR> phrs) {
		return phrs.stream().filter((el) -> (BMI(el.weight, el.height) >= 30)).map(el-> el.name).collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * gives back list of over weight
	 * @param phrs
     * @return
     */
	private LinkedList<String> filterOver(final LinkedList<PHR> phrs) {
		return phrs.stream().filter((el) -> (BMI(el.weight, el.height) >= 25 &&
				BMI(el.weight, el.height) <  30)).map(el-> el.name).collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * gives back list of healthy weigths
	 * @param phrs
     * @return
     */
	private LinkedList<String> filterHealthy(final LinkedList<PHR> phrs) {
		return phrs.stream().filter((el) -> (BMI(el.weight, el.height) >= 18.5 &&
				BMI(el.weight, el.height) < 25)).map(el-> el.name).collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * gives back list of underweight
	 * @param phrs
     * @return
     */
	private LinkedList<String> filterUnderWeight(final LinkedList<PHR> phrs) {
		return phrs.stream().filter((el) -> (BMI(el.weight, el.height) < 18.5)).map(el-> el.name).collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * gives back BMI of given numbers
	 * @param weight
	 * @param height
     * @return
     */
	double BMI (final double weight, final double height)
	{
		return weight / (height*height);
	}


}