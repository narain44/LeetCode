Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

 ```
 Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
```

## Solution

```
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

```
---
**Time Complexity** : O(P+B), where P=Paragraph,B=BannedWorlds, since we loop through the Banned words and  Paragraph once.

**Space Complexity** : O(P+B), where P=Paragraph,B=BannedWorld, since we store the Banned words and  Paragraph.
