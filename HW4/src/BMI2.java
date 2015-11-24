import java.util.LinkedList;
import java.util.stream.Collectors;

class BMI2 implements IBMIProbs {
	BMI2(){}

	//using a filter
	@Override
	public BMISummary bmiReport(final LinkedList<PHR> phrs) {


		final LinkedList<String> under = filterUnderWeight(phrs);
		final LinkedList<String>  healthy = filterHealthy(phrs);
		final LinkedList<String> overweight = filterOver(phrs);
		final LinkedList<String> obese = filterObese(phrs);

		return new BMISummary(under, healthy, overweight, obese);
	}

	private LinkedList<String> filterObese(final LinkedList<PHR> phrs) {
		return phrs.stream().filter((el) -> (BMI(el.weight, el.height) >= 30)).map(el-> el.name).collect(Collectors.toCollection(LinkedList::new));
	}

	private LinkedList<String> filterOver(final LinkedList<PHR> phrs) {
		return phrs.stream().filter((el) -> (BMI(el.weight, el.height) >= 25 &&
				BMI(el.weight, el.height) <  30)).map(el-> el.name).collect(Collectors.toCollection(LinkedList::new));
	}

	private LinkedList<String> filterHealthy(final LinkedList<PHR> phrs) {
		return phrs.stream().filter((el) -> (BMI(el.weight, el.height) >= 18.5 &&
				BMI(el.weight, el.height) < 25)).map(el-> el.name).collect(Collectors.toCollection(LinkedList::new));
	}

	private LinkedList<String> filterUnderWeight(final LinkedList<PHR> phrs) {
		return phrs.stream().filter((el) -> (BMI(el.weight, el.height) < 18.5)).map(el-> el.name).collect(Collectors.toCollection(LinkedList::new));
	}

	double BMI (final double weight, final double height)
	{
		return weight / (height*height);
	}


}