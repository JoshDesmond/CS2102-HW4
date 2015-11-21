
import java.util.LinkedList;
import java.util.stream.Collectors;

class DataSmooth1 implements IDataSmoothProbs {
  DataSmooth1(){}
  
  public LinkedList<Double> dataSmooth(LinkedList<PHR> phrs) {
    LinkedList<Integer> original = phrs.stream().map(el -> el.heartRate).collect(Collectors.toCollection(LinkedList::new));
    LinkedList<Double> changes = new LinkedList<>();
    changes.add(new Double(original.get(0)));
    for (int i = 1; i < original.size() -1; i++) {
      Integer ints = original.get(i);
        changes.set(i, average(original.get(i-1) ,original.get(i), original.get(i+1)));
    }
    changes.add(new Double(original.get(original.size()-1)));
    return changes;
  }
  public Double average(int one, int two, int three)
  {
    return new Double((one + two + three) / 3.);
  }
}