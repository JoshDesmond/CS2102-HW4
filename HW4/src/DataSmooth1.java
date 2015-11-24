
import java.util.LinkedList;
import java.util.stream.Collectors;

class DataSmooth1 implements IDataSmoothProbs {
    DataSmooth1() {
    }

    public LinkedList<Double> dataSmooth(LinkedList<PHR> phrs) {
        LinkedList<Double> originalList = mapToHeartRates(phrs);

        // Check if size is less than three.
        if (phrs.size() <= 2) {
            return originalList;
        }

        // Instantiate modifiedList
        LinkedList<Double> modifiedList = new LinkedList<>();
        // Add first value
        modifiedList.add(new Double(originalList.get(0)));

        for (int index = 1; index < originalList.size() - 1; index++) {
            // Extract valPrev, Curr, and Next.
            final Double valPrev = originalList.get(index - 1);
            final Double valCurr = originalList.get(index);
            final Double valNext = originalList.get(index + 1);

            // Add to modifiedList the average of three values.
            modifiedList.add(index, average(valPrev, valCurr, valNext));
        }

        // Add last value.
        modifiedList.add(originalList.get(originalList.size() - 1));
        return modifiedList;
    }

    /**
     * @return average of three doubles
     */
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