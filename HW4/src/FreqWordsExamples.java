
import tester.*;

class FreqWordsExamples {
  IFreqWordsProbs F;
  
  FreqWordsExamples(IFreqWordsProbs F) {
    this.F = F;
  }
  
  boolean testFoo (Tester t) {
    return t.checkExpect(F.frequentWords(null), null);
  }
}