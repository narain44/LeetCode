package firstUniqueCharacter;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int firstUniqChar(String s) {
        if(s==null || s.length()==0){
            return -1;
        }
        Map<Character,Integer> charCountMap=new HashMap<>();
        //Build a HashMap , time O(n), space O(n)
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            if(charCountMap.get(c)==null){
                charCountMap.put(c,1);
            }else{
                charCountMap.put(c,charCountMap.get(c)+1);
            }
        }

        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            if(charCountMap.get(c) == 1)
                return i;
        }
        return -1;
    }

    public static void main(String [] args){
        String strToCheck="LeetCodeLove";
        int indexOfUniqChar=new Solution().firstUniqChar(strToCheck);
        System.out.println("First Unique char is "+strToCheck.charAt(indexOfUniqChar));
    }
}
