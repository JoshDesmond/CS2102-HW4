
import java.util.Arrays;
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
        if(curCount > minCount || (curCount == minCount && curString.length() < minString.length()))
        {
          minCount = curCount;
          minString = curString;
        }

        if(curCount> medCount || (curCount == medCount && curString.length() < medString.length()))
        {
          minCount = medCount;
          minString = medString;

          medString = curString;
          medCount = curCount;
        }

        if(curCount> maxCount || (curCount == maxCount && curString.length() < maxString.length()))
        {


          medString = maxString;
          medCount = maxCount;

          maxString = curString;
          maxCount = curCount;
        }
        curString = s;
        curCount =1;

      }
      else
        curCount +=1;
    }
    if(curCount > minCount || (curCount == minCount && curString.length() < minString.length()))
    {
      minCount = curCount;
      minString = curString;
    }

    if(curCount> medCount || (curCount == medCount && curString.length() < medString.length()))
    {
      minCount = medCount;
      minString = medString;

      medString = curString;
      medCount = curCount;
    }

    if(curCount> maxCount || (curCount == maxCount && curString.length() < maxString.length()))
    {


      medString = maxString;
      medCount = maxCount;

      maxString = curString;
      maxCount = curCount;
    }

  return new LinkedList<String>(Arrays.asList(maxString, medString,minString));
  }
}