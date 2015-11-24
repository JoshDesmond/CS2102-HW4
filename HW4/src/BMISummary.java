import java.util.LinkedList;

class BMISummary {
    LinkedList<String> under;
    LinkedList<String> healthy;
    LinkedList<String> over;
    LinkedList<String> obese;

    /**
     * Build BMI summary in the given order: under, healthy, over, obese
     */
    BMISummary(final LinkedList<String> under, final LinkedList<String> healthy,
            final LinkedList<String> over, final LinkedList<String> obese) {
        this.under = under;
        this.healthy = healthy;
        this.over = over;
        this.obese = obese;
    }

}