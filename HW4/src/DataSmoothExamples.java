
import tester.*;

class DataSmoothExamples {
  IDataSmoothProbs D;
  
  DataSmoothExamples(IDataSmoothProbs D) {
    this.D = D;
  }
  
  boolean testFoo (Tester t) {
    return t.checkExpect(D.dataSmooth(null), null);
  }
  
}