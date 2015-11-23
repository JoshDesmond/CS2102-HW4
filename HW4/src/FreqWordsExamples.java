
import tester.*;


import java.util.Arrays;
import java.util.LinkedList;

class FreqWordsExamples {
  IFreqWordsProbs F;
  
  FreqWordsExamples(IFreqWordsProbs F) {
    this.F = F;
  }
  
  boolean testSimple (Tester t) {
    LinkedList<String>  test = new LinkedList<String>(Arrays.asList("1", "2","2","3","3","3","4","4","4","4"));
    LinkedList<String>  answers = new LinkedList<String>(Arrays.asList("4", "3", "2"));
    return t.checkExpect(F.frequentWords(test), answers);
  }
  boolean testSameNumber (Tester t)
  {
    LinkedList<String>  test = new LinkedList<String>(Arrays.asList("1","22","333","4444"));
    LinkedList<String>  answers = new LinkedList<String>(Arrays.asList("1", "22", "333"));
    return t.checkExpect(F.frequentWords(test), answers);
  }
}