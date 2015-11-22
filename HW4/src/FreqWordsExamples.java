
import tester.*;


import java.util.Arrays;
import java.util.LinkedList;

class FreqWordsExamples {
  IFreqWordsProbs F;
  
  FreqWordsExamples(IFreqWordsProbs F) {
    this.F = F;
  }
  
  boolean testSimple (Tester t) {
    LinkedList<String>  test = new LinkedList<String>(Arrays.asList("hello","my", "name","name","name", "my" ,"I"));
    LinkedList<String>  answers = new LinkedList<String>(Arrays.asList("name", "my", "I"));
    return t.checkExpect(F.frequentWords(test), answers);
  }
}