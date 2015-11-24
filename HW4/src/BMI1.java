import java.util.LinkedList;

class BMI1 implements IBMIProbs {
    BMI1() {
    }

    @Override
    /*
     * (non-Javadoc) This implementation works like so: First the
     * 
     * @see IBMIProbs#bmiReport(java.util.LinkedList)
     */
    public BMISummary bmiReport(final LinkedList<PHR> phrs) {
        if (phrs == null) { // Argument validation
            throw new IllegalArgumentException("phrs was null");
        }

        BMISummaryFactory factory = new BMISummaryFactory();

        for (PHR report : phrs) {
            factory.addPerson(report);
        }

        return factory.build();
    }

    /**
     * Enum representing different classes of BMI health. Use
     * {@link getBMIClass} to convert from a double to a BMIScale.
     */
    public enum BMIScale {
        UNDERWEIGHT(0.0, 18.5), HEALTHY(18.5, 25.0), OVERWEIGHT(25.0,
                30.0), OBESE(30.0, Double.MAX_VALUE);

        private double lowerBound;
        private double upperBound;

        BMIScale(final double lowerBound, final double upperBound) {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }
    }

    /**
     * Returns the {@link BMIScale} which the given double falls between.
     * 
     * @param bmi
     *            a positive double representing BMI
     * @return one of the classes of weight within BMIScale
     */
    public static BMIScale getBMIClass(final Double bmi) {
        for (final BMIScale bmiClass : BMIScale.values()) {
            if (bmiClass.lowerBound <= bmi && bmi < bmiClass.upperBound) {
                return bmiClass;
            }
        }

        throw new IllegalArgumentException(String.format(
                "BMI value of %s given that was not in the range of BMIScale",
                bmi));
    }

    /**
     * Factory for the data class {@link BMISummary}
     */
    public class BMISummaryFactory {

        private LinkedList<String> under;
        private LinkedList<String> healthy;
        private LinkedList<String> over;
        private LinkedList<String> obese;

        public BMISummaryFactory() {
            under = new LinkedList<String>();
            healthy = new LinkedList<String>();
            over = new LinkedList<String>();
            obese = new LinkedList<String>();
        }

        public BMISummaryFactory addPerson(PHR record) {
            switch (getBMIClass(record.getBMI())) {
            case UNDERWEIGHT:
                under.add(record.name);
                break;
            case HEALTHY:
                healthy.add(record.name);
                break;
            case OVERWEIGHT:
                over.add(record.name);
                break;
            case OBESE:
                obese.add(record.name);
                break;
            default:
                throw new IllegalArgumentException("Unreachable code in enum");
            }

            return this;
        }

        public BMISummary build() {
            return new BMISummary(under, healthy, over, obese);
        }
    }
}