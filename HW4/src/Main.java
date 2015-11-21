
import tester.Tester;
//testing
class Main {
	// This is set up to run your tests in each Examples class
	//   on each of your two solutions to that problem
	//
	// Comment out lines for any examples that you don't want to run.
	public static void main(final String[] args) {
		Tester.run (new BMIExamples (new BMI1())) ;
		Tester.run (new BMIExamples (new BMI2())) ;
		Tester.run (new BMIExamples (new BMI3())) ;
		Tester.run (new BMIExamples (new BMI4())) ;
		Tester.run (new EarthquakeExamples (new Earthquake1())) ;
		Tester.run (new EarthquakeExamples (new Earthquake2())) ;
		Tester.run (new DataSmoothExamples (new DataSmooth1())) ;
		Tester.run (new DataSmoothExamples (new DataSmooth2())) ;
		Tester.run (new FreqWordsExamples (new MostFrequentWords1())) ;
		Tester.run (new FreqWordsExamples (new MostFrequentWords2())) ;
	}
}
