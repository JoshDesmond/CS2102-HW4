
import java.util.LinkedList;
import java.util.stream.Collectors;

class DataSmooth1 implements IDataSmoothProbs {
    DataSmooth1() {
    }

    public LinkedList<Double> dataSmooth(LinkedList<PHR> phrs) {
        LinkedList<Double> original = mapToHeartRates(phrs);

        if (phrs.size() <= 2) {
            return original;
        }

        LinkedList<Double> changes = new LinkedList<>();
        changes.add(new Double(original.get(0)));
        for (int i = 1; i < original.size() - 1; i++) {
            changes.add(i, average(original.get(i - 1), original.get(i),
                    original.get(i + 1)));
        }
        changes.add(new Double(original.get(original.size() - 1)));
        return changes;
    }

    public Double average(double double1, double double2, double double3) {
        return (double1 + double2 + double3) / 3.;
    }

    /**
     * Maps list of phrs to list of just heartrates.
     * 
     * @param phrs
     *            LinkedList of PHR's
     * @return LinkedList of doubles
     */
    private LinkedList<Double> mapToHeartRates(LinkedList<PHR> phrs) {
        return phrs.stream().map(el -> el.heartRate * 1.0)
                .collect(Collectors.toCollection(LinkedList::new));
    }
}