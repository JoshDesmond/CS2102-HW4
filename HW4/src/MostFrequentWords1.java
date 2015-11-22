
import java.util.*;

class MostFrequentWords1 implements IFreqWordsProbs {
    MostFrequentWords1(){}

    public LinkedList<String> frequentWords(LinkedList<String> words) {
        Map<String, ICount> uniq = getUniq(words);

        for(String s: words)
        {
            uniq.get(s).incramentCount();
        }


        ICount max = new EmptyCount();
        ICount min = new EmptyCount();
        ICount med = new EmptyCount();
        System.out.println(uniq.values());
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
                    if(current.count() >= max.count())
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
        LinkedList<String> mostFreq = new LinkedList<>();
        mostFreq.add(((WordCount)max).str);
        mostFreq.add(((WordCount)med).str);
        mostFreq.add(((WordCount)min).str);
        return mostFreq;



    }
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
    interface ICount
    {
        int length();
        int count();
        void incramentCount();
    }
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
    class EmptyCount implements ICount
    {

        @Override
        public int length() {
            return 32767;
        }

        @Override
        public int count() {
            return 0;
        }

        @Override
        public void incramentCount() {
            return;
        }
    }
}