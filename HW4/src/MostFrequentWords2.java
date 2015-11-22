
import java.util.LinkedList;

class MostFrequentWords2 implements IFreqWordsProbs {
  MostFrequentWords2(){}
  // single pass
  public LinkedList<String> frequentWords(LinkedList<String> words) {
    String maxString = "";
    int maxCount = 0;

    String medString = "";
    int medCount = 0;

    String minString = "";
    int minCount = 0;

    String curString = "";
    int curCount = 0;
    words.sort(String::compareTo);
    for(String s : words)
    {
      if(!s.equals(curString))
      {
        //swap swap etc
        curString = s;
        curCount =1;

      }
      else
        curCount +=1;
    }
  return null;
  }
}