
import java.util.LinkedList;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;

class DataSmooth2 implements IDataSmoothProbs {
  DataSmooth2(){}
  
  public LinkedList<Double> dataSmooth(LinkedList<PHR> phrs) {
    LinkedList<TripleNum> triples = new LinkedList<TripleNum>();
    toTriples(phrs, triples);
    LinkedList<Double> average = new LinkedList<>();
    for(TripleNum t : triples)
    {
      average.add(t.average());
    }
    return average;
  }

  private void toTriples(LinkedList<PHR> phrs, LinkedList<TripleNum> triples) {
    for(int i = 0; i < phrs.size(); i++)
    {
      if(i == 0)
      {
        triples.add(new TripleNum(phrs.get(i).heartRate, phrs.get(i).heartRate, phrs.get(i).heartRate));
      }
      else if(i == phrs.size()-1)
      {
        triples.add(new TripleNum(phrs.get(i).heartRate, phrs.get(i).heartRate, phrs.get(i).heartRate));
      }
      else{
        triples.add(new TripleNum(phrs.get(i-1).heartRate, phrs.get(i).heartRate, phrs.get(i+1).heartRate));
      }
    }
  }

  class TripleNum{
    Integer one;
    Integer two;
    Integer three;

    TripleNum(Integer a, Integer b, Integer c)
    {
      one =a;
      two = b;
      three = c;
    }
    Double average ()
    {
      return new Double((one + two + three) / 3.);
    }


  }
}