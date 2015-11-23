import java.util.*;

class MostFrequentWords1 implements IFreqWordsProbs {
    MostFrequentWords1(){}

    //Data Cleaning: Turn in to a map of word counts, hold both WordCount, which holds word and count. Find max 3 in that list
    public LinkedList<String> frequentWords(LinkedList<String> words) {

        //get unique words
        Map<String, ICount> uniq = getUniq(words);
        // gets the number of occurences for each unique word
        for(String s: words)
        {
            uniq.get(s).incramentCount();
        }

        // temporary holder for min med and max counts
        ICount max = new EmptyCount();
        ICount min = new EmptyCount();
        ICount med = new EmptyCount();

        // find the 3 highest occurrences of words
        for(ICount current : uniq.values())
        {
            if(current.count() >= min.count())
            {
                if(current.count() == min.count()){
                    if(current.length() < min.length())
                    {
                        min = current;
                    }
                }
                else
                    min = current;

                if(current.count() >= med.count())
                {
                    if(current.count() == med.count())
                    {
                        if(current.length() < med.length())
                        {
                            ICount temp = current;
                            min = med;
                            med = temp;
                        }
                    }
                    else
                    {
                        ICount temp = current;
                        min = med;
                        med = temp;
                    }
                    if(current.count() >= max.count() )
                    {
                        if(current.count() == max.count())
                        {
                            if(current.length() < max.length())
                            {
                                ICount temp = current;
                                med = max;
                                max = temp;
                            }
                        }
                        else
                        {
                            ICount temp = current;
                            med = max;
                            max = temp;
                        }

                    }
                }

            }
        }
        // adds three highest occurrences to list
        LinkedList<String> mostFreq = new LinkedList<>();
        mostFreq.add(((WordCount)max).str);
        mostFreq.add(((WordCount)med).str);
        mostFreq.add(((WordCount)min).str);
        return mostFreq;



    }
    // adds each unique word to a map
    Map<String, ICount> getUniq(LinkedList<String> words)
    {
        Map< String, ICount> uniq = new HashMap<String,ICount>();
        for(String s : words)
        {
            if(!uniq.containsKey(s))
            {
                uniq.put(s, new WordCount(s));
            }
        }
        return uniq;
    }
    // interface for count
    interface ICount
    {

        int length();// gets length of the held string
        int count();// gets the number of times that string appears
        void incramentCount(); // increases the held count by 1
    }
    // holds string and count
    class WordCount implements ICount
    {
        String str;
        int count = 0;
        WordCount (String s)
        {
            str = s;
        }
        public String toString()
        {
            return str + " num: " + count;
        }

        @Override
        public int length() {
            return str.length();
        }

        @Override
        public int count() {
            return count;
        }

        @Override
        public void incramentCount() {
            count +=1;
        }
    }
    // represents an empty counter
    class EmptyCount implements ICount
    {

        @Override

        public int length() {
            return Integer.MAX_VALUE;
        }

        @Override
        // -1 is a valid error imput because each new count will be at least 1
        public int count() {
            return -1;
        }

        @Override
        public void incramentCount() {
            return;
        }
    }
}