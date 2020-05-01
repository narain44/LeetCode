```
public String mostCommonWord(String paragraph, String[] banned) {
  //Sanity Check
  if(paragraph == null || paragraph.length()==0){
    return null;
  }
  
  //Construct a set of banned words
  Set<String> setBannedWords=new HashSet<>();
  for(String word:banned) setBannedWords.add(word);
  
  //Intialize a SB and countMap
  StringBuilder wordSB=new StringBuider();
  Map<String,Integer> wordCountMap = new HashMap<String,Integer>();
  String answer="";
  int answerNumberOfOccurances=0;
  for(int i=0;i<paragraph.length;i++){
    Character c=paragraph.charAt(i);
    if(c.isLetter()){
      wordSB.append(tolowercase(c));
    }else{
      if(wordSB.size != 0){
        String word=wordSB.toString();
        if(!setBannedWords.contains(word)){
          wordCountMap.put(word,wordCountMap.getOrDefault(word,0)+1);
          if(wordCountMap.get(word) > answerNumberOfOccurances){
            answer=word;
            answerNumberOfOccurances=wordCountMap.get(word);
          }
        }  
    }
  }
  return answer;
}

```
