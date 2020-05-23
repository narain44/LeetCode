package TreeWordLadderII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BTWordLadderII {

    public static void main(String[] args) {
        BTWordLadderII instance = new BTWordLadderII();
        List<String> wordList = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log"});
        List<List<String>> result = instance.findLadders("hit", "cog", wordList);
        System.out.println(Arrays.deepToString(result.toArray()));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        return null;
    }

    private boolean findCombinations(String beginWord,String endWord,List<String> wordList,List<List<String>> result,List<String> wordPath){
        boolean foundPath=false;
        for(String dictWords:wordList){
            if(differsby1(beginWord,dictWords)){
                wordPath.add(dictWords);
                if(dictWords.equals(endWord)) return true;
                foundPath=findCombinations(dictWords,endWord,wordList,result,wordPath);
            }
        }
        return false;
    }

    private boolean differsby1(String word1, String word2) {
        if (word1 == null || word2 == null || word1.length() != word2.length()) return false;
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
                if (diffCount > 2) return false;
            }
        }
        if (diffCount == 1) return true;
        return false;
    }


}
