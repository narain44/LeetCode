package educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithSameLetters06 {

    public static void main(String[] args) {
        System.out.println("Result for String=aabccbb, k=2 " +findLength("aabccbb",2));
        System.out.println("Result for String=abbcb, k=1 " +findLength("abbcb",1));
        System.out.println("Result for String=abccde, k=1 " +findLength("abccde",1));
    }

    public static int findLength(String str, int k) {
        int start=0;
        int maxCharCount=0;
        int result=0;
        Map <Character,Integer> windowCharCount=new HashMap<>();

        for(int end=0;end<str.length();end++){
            Character currentChar=str.charAt(end);
            windowCharCount.put(currentChar,windowCharCount.getOrDefault(currentChar,0)+1);
            maxCharCount=Math.max(maxCharCount,windowCharCount.get(currentChar));
            if( (end-start+1)-maxCharCount > k){ //Shrink Window
                Character startChar=str.charAt(start);
                windowCharCount.put(startChar,windowCharCount.get(startChar)-1);
                start++;
            }
            result=Math.max(result,end-start+1);
        }
        return result;
    }
}
