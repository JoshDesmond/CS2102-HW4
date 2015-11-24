
import java.util.LinkedList;

class DataSmooth2 implements IDataSmoothProbs {
    DataSmooth2() {
    }
    // gives back a list of smoothed data
    public LinkedList<Double> dataSmooth(LinkedList<PHR> phrs) {
       // create list of triples
        LinkedList<TripleNum> triples = new LinkedList<TripleNum>();
        toTriples(phrs, triples);
        LinkedList<Double> average = new LinkedList<>();
        // convert list of triples to their averages
        for (TripleNum t : triples) {
            average.add(t.average());
        }
        return average;
    }
    // conversts list of phrs to list of TripleNum
    private void toTriples(LinkedList<PHR> phrs,
            LinkedList<TripleNum> triples) {
        for (int i = 0; i < phrs.size(); i++) {
            if (i == 0) {
                triples.add(new TripleNum(phrs.get(i).heartRate,
                        phrs.get(i).heartRate, phrs.get(i).heartRate));
            } else if (i == phrs.size() - 1) {
                triples.add(new TripleNum(phrs.get(i).heartRate,
                        phrs.get(i).heartRate, phrs.get(i).heartRate));
            } else {
                triples.add(new TripleNum(phrs.get(i - 1).heartRate,
                        phrs.get(i).heartRate, phrs.get(i + 1).heartRate));
            }
        }
    }

    /**
     * private class to hold three consecutive nubmers
     */
    private class TripleNum {
        int one;
        int two;
        int three;

        TripleNum(int a, int b, int c) {
            one = a;
            two = b;
            three = c;
        }

        /**
         * gives the average of the three held numbers
         * @return
         */
        Double average() {
            return ((one + two + three) / 3.);
        }

    }
}