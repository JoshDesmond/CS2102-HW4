
import java.util.Arrays;
import java.util.LinkedList;

class MostFrequentWords2 implements IFreqWordsProbs {
    MostFrequentWords2() {
    }

    // single pass
    public LinkedList<String> frequentWords(LinkedList<String> words) {
        // store temporary string and frequency counts
        String maxString = "";
        int maxCount = 0;

        String medString = "";
        int medCount = 0;

        String minString = "";
        int minCount = 0;

        String curString = "";
        int curCount = 0;
        // sort list in alphabetic order
        words.sort(String::compareTo);
        for (String s : words) {
            // any mismatch signals the end of the current series of words
            if (!s.equals(curString)) {
                // shift down words with lower counts
                if (isLarger(curCount, minCount, curString.length(),
                        minString.length())) {
                    minCount = curCount;
                    minString = curString;
                }
                if (isLarger(curCount, medCount, curString.length(),
                        medString.length())) {
                    minCount = medCount;
                    minString = medString;

                    medString = curString;
                    medCount = curCount;
                }
                if (isLarger(curCount, maxCount, curString.length(),
                        maxString.length())) {

                    medString = maxString;
                    medCount = maxCount;

                    maxString = curString;
                    maxCount = curCount;
                }
                curString = s;
                curCount = 1;

            } else
                curCount += 1; // increase the counter for the current series of
                               // words by one
        }
        // add the last element held
        if (isLarger(curCount, minCount, curString.length(),
                minString.length())) {
            minCount = curCount;
            minString = curString;
        }

        if (isLarger(curCount, medCount, curString.length(),
                medString.length())) {
            minCount = medCount;
            minString = medString;

            medString = curString;
            medCount = curCount;
        }

        if (isLarger(curCount, maxCount, curString.length(),
                maxString.length())) {

            medString = maxString;
            medCount = maxCount;

            maxString = curString;
            maxCount = curCount;
        }

        return new LinkedList<String>(
                Arrays.asList(maxString, medString, minString));
    }

    /**
     * method to do comparison for the current count against min med and max
     * counts
     */
    boolean isLarger(int current, int compare, int lengthCurrent,
            int lengthCompare) {
        return current > compare
                || (current == compare && lengthCurrent < lengthCompare);
    }
}
