package educative.slidingwindow;

import java.util.Arrays;

public class LongestNoRepeatSubstring05 {
    public static void main(String []args){
        System.out.println("Longest no repeat substring in aabccbb is "+findLength("aabccbb"));
        System.out.println("Longest no repeat substring in abbbb is "+findLength("abbbb"));
        System.out.println("Longest no repeat substring in abccde is "+findLength("abccde"));
    }

    public static int findLength(String str) {
        int [] charMap=new int[26];
        Arrays.fill(charMap,-1);
        int start=0;
        int result=0;
        for(int i=0;i<str.length();i++){
            Character current=str.charAt(i);
            start = Math.max(start,charMap[current-'a']);
            result=Math.max(result,i-start+1);
            charMap[current-'a']=i+1;
        }
        return result;
    }
}
