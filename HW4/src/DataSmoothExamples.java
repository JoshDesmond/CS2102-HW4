
import tester.*;

import java.util.Arrays;
import java.util.LinkedList;

class DataSmoothExamples {
  IDataSmoothProbs D;
  
  DataSmoothExamples(IDataSmoothProbs D) {
    this.D = D;
  }
  
  boolean testGiven  (Tester t)
  {
    //95 102 98 88 105
    LinkedList<PHR> phrs = new LinkedList<PHR>(Arrays.asList(
            new PHR("1", new Integer(3),new Integer(3), new Integer(95)),
            new PHR("1", new Integer(3),new Integer(3), new Integer(102)),
            new PHR("1", new Integer(3),new Integer(3), new Integer(98)),
            new PHR("1", new Integer(3),new Integer(3), new Integer(88)),
            new PHR("1", new Integer(3),new Integer(3), new Integer(105))
    ));
//  95 98.33 96 97 105
    LinkedList<Double> answers = new LinkedList<Double>(Arrays.asList(
            new Double(95),
            new Double((95 + 102 + 98) / 3.),
            new Double(96),
            new Double(97),
            new Double(105)
    ));
    return t.checkExpect(D.dataSmooth(phrs), answers);
  }
  
}