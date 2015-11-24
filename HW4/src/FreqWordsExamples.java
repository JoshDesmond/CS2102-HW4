
import java.util.Arrays;
import java.util.LinkedList;

import tester.TestMethod;
import tester.Tester;

class FreqWordsExamples {
    IFreqWordsProbs F;

    FreqWordsExamples(IFreqWordsProbs F) {
        this.F = F;
    }

    // test unique occurrences
    public boolean testSimple(Tester t) {
        LinkedList<String> test = new LinkedList<String>(Arrays.asList("1", "4",
                "4", "4", "4", "2", "2", "3", "3", "3"));
        LinkedList<String> answers = new LinkedList<String>(
                Arrays.asList("4", "3", "2"));
        return t.checkExpect(F.frequentWords(test), answers);
    }

    // test different lengths and same frequency
    public boolean testSameNumber(Tester t) {
        LinkedList<String> test = new LinkedList<String>(
                Arrays.asList("1", "22", "333", "4444"));
        LinkedList<String> answers = new LinkedList<String>(
                Arrays.asList("1", "22", "333"));
        return t.checkExpect(F.frequentWords(test), answers);
    }

    @TestMethod
    public boolean testLargeDataSet(Tester t) {
        return t.checkExpect(F.frequentWords(getLargeInputData()),
                getLargeOutputData());
    }

    public static LinkedList<String> getLargeInputData() {
        LinkedList<String> listMainVals = new LinkedList<String>(Arrays.asList(
                "leonine", "leonine", "leonine", "doyly", "doyly", "chide",
                "sorites", "sorites", "sorites", "torrify", "relater",
                "maximin", "maximin", "brownie", "berio", "synchro", "write",
                "capataz", "capataz", "capataz", "capataz", "capataz", "puzzle",
                "manchu", "manchu", "manchu", "manchu", "manchu", "liny",
                "bangkok", "couth", "pres", "mohair", "bib")); // Most any items
                                                               // occur is 5
                                                               // times.

        LinkedList<String> listImportantVals = new LinkedList<String>(
                Arrays.asList("occurs7times", "occurs7times", "occurs7times",
                        "occurs7times", "occurs7times", "occurs7times",
                        "occurs7times", "occurs7timesbutislong",
                        "occurs7timesbutislong", "occurs7timesbutislong",
                        "occurs7timesbutislong", "occurs7timesbutislong",
                        "occurs7timesbutislong", "occurs7timesbutislong", "5",
                        "5", "5", "5", "5"));

        listMainVals.addAll(listImportantVals);
        java.util.Collections.shuffle(listMainVals);
        return listMainVals;
    }

    public static LinkedList<String> getLargeOutputData() {
        LinkedList<String> outputList = new LinkedList<String>(
                Arrays.asList("occurs7times", "occurs7timesbutislong", "5"));

        return outputList;
    }

}