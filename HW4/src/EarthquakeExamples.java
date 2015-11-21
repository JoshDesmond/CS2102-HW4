
import tester.*;

class EarthquakeExamples {
  IEarthquakeProbs E;
  
  EarthquakeExamples(IEarthquakeProbs E) {
    this.E = E;
  }
  
  boolean testFoo (Tester t) {
    return t.checkExpect(E.dailyMaxForMonth(null,0), null);
  }
}