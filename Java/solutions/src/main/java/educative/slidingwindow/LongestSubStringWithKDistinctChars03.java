package educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKDistinctChars03 {
    public static void main(String [] args){
        int result=LongestSubStringWithKDistinctChars03.longestSubStringWithKDistinctChars("araaci",2);
        System.out.println("Result for aaraci is "+result);

        result=LongestSubStringWithKDistinctChars03.longestSubStringWithKDistinctChars("araaci",1);
        System.out.println("Result for aaraci is "+result);

        result=LongestSubStringWithKDistinctChars03.longestSubStringWithKDistinctChars("cbbebi",3);
        System.out.println("Result for cbbebi is "+result);

    }

    private static int longestSubStringWithKDistinctChars(String str,int k){
        int result=Integer.MIN_VALUE;
        int start=0;
        Map<Character,Integer> charMap=new HashMap<>();
        for(int end=0;end<str.length()-1;end++){
            Character current=str.charAt(end);
            charMap.put(current,end);
            //Check the size
            if(charMap.size() <= k) {
                result = Math.max(result, (end - start) + 1);
            } else if(charMap.size() > k){
                Character startCharacter=str.charAt(start);
                start=charMap.get(startCharacter)+1;
                charMap.remove(startCharacter);
            }
        }
        return result;
    }
}
