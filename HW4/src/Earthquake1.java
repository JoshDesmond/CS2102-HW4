import java.util.LinkedList;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Earthquake1 implements IEarthquakeProbs {
    Earthquake1() {
    }

    @Override
    public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data,
            int month) {
        // this first line of code ensure input isn't destroyed
        data = (LinkedList<Double>) data.clone();

        // First split data.
        LinkedList<LinkedList<Double>> splitData = splitLists(data);

        // Then filter through and retrieve only data for given month.
        splitData = splitData.stream().filter(getPredicate(month))
                .collect(Collectors.toCollection(LinkedList::new));

        // Then convert these dailyDataLists into MaxHzReads.
        Function<LinkedList<Double>, MaxHzReport> mapFunction = getMapFunction();
        return splitData.stream().map(mapFunction)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Returns a function which maps a dailyDataList into a MaxHzReads.
     * DailyDataLists are in the form: <i>{yyyymmdd, val1, val2, ... }</i>.
     * Current implementation has the side effect of destroying the given list
     * it's working on.
     * 
     * @return Function mapping dailyData to MaxHzReport
     */
    private static Function<LinkedList<Double>, MaxHzReport> getMapFunction() {
        // Define function using -> notation.
        Function<LinkedList<Double>, MaxHzReport> function = list -> {
            double dateDouble = list.pop();
            int day = EarthquakeUtils.dayOfDate(dateDouble);

            // Find best
            double maxRead = 0.0;
            for (double read : list) {
                if (read > maxRead) {
                    maxRead = read;
                }
            }

            return new MaxHzReport(day, maxRead);
        };

        return function;
    }

    /**
     * Converts raw sensor data into split data
     * 
     * @return Builds lists of daily reading lists. Each list within total list
     *         will begin with a date.
     */
    private LinkedList<LinkedList<Double>> splitLists(
            LinkedList<Double> sensorData) {
        // Set up iterator
        LinkedList<LinkedList<Double>> splitList = new LinkedList<LinkedList<Double>>();
        LinkedList<Double> currentList = new LinkedList<Double>();

        currentList.add(sensorData.pop());

        while (!sensorData.isEmpty()) {
            Double peek = sensorData.peek();

            if (EarthquakeUtils.isOfTypeDate(peek)) {
                // Then terminate currentList and start anew.
                splitList.add(currentList);
                currentList = new LinkedList<Double>();
            } else if (!EarthquakeUtils.isOfTypeFreq(peek)) {
                throw new IllegalArgumentException(String
                        .format("Given argument within sensor data list was neither of type "
                                + "frequency nor date: %s", peek));
            }

            currentList.add(sensorData.pop());
        }

        splitList.add(currentList);
        return splitList;
    }

    /**
     * Returns a predicate which determines which month this parsed data belongs
     * to.
     * 
     * @param month
     *            int between 1 and 12 inclusive
     * @return Predicate function of (LinkedList<Double> -> boolean).
     */
    public static Predicate<? super LinkedList<Double>> getPredicate(
            int month) {
        if (0 >= month || 12 < month) {
            throw new IllegalArgumentException(
                    String.format("Given month is not valid %s", month));
        }

        Predicate<? super LinkedList<Double>> func = (list -> EarthquakeUtils
                .monthOfDate(list.peek()) == month);

        return func;
    }

}
