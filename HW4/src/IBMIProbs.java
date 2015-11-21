import java.util.LinkedList;

interface IBMIProbs {
	/**
	 * Produces a BMISummary object given
	 * produces The names can be in any order. Use the BMISummary class in the
	 * starter files for the report:
	 * 
	 * A simplified BMI scale classifies a value below 18.5 as “underweight”, a
	 * value at least 18.5 but under 25 as “healthy”, a value at least 25 but
	 * under 30 as “overweight”, and a value at least 30 as “obese”.
	 * 
	 * @param phrs
	 *            a list of personal health records
	 * @return a report containing a list of names (not the entire records) of
	 *         patients in each BMI classification category.
	 */
	BMISummary bmiReport(LinkedList<PHR> phrs);

}