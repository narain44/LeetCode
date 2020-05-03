package MostCommonWord;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        //Sanity Check
        if (paragraph == null || paragraph.length() == 0) {
            return null;
        }

        //This Ensures that there is alteast one non letter character at the end
        paragraph=paragraph+".";

        //Construct a set of banned words
        Set<String> setBannedWords = new HashSet<>();
        for (String word : banned) setBannedWords.add(word);

        //Intialize a SB and countMap
        StringBuilder wordSB = new StringBuilder();
        Map<String, Integer> wordCountMap = new HashMap<String, Integer>();
        String answer = "";
        int answerNumberOfOccurances = 0;
        for (int i = 0; i < paragraph.length(); i++) {
            Character c = paragraph.charAt(i);
            if (Character.isLetter(c)) {
                wordSB.append(Character.toLowerCase(c));
            } else if (wordSB.length() > 0){
                String word = wordSB.toString();
                if (!setBannedWords.contains(word)) {
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    if (wordCountMap.get(word) > answerNumberOfOccurances) {
                        answer = word;
                        answerNumberOfOccurances = wordCountMap.get(word);
                    }
                }
                wordSB = new StringBuilder();
            }
        }
        return answer;
    }
}
