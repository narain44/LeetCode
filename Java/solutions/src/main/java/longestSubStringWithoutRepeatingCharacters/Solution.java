package longestSubStringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        System.out.println("Hello");
        Set<Character> charactersSoFar=new HashSet<Character>();
        int maxLength=0;
        for(int i=0;i<s.length();i++){
//            Character characterToCheck=s.charAt(i);
//            if(charactersSoFar.contains(characterToCheck)){
//                if(charactersSoFar.size()>maxLength){
//                    maxLength=charactersSoFar.size();
//                    charactersSoFar=new HashSet<Character>();
//                }
//            }
            charactersSoFar.add(s.charAt(i));
        }
//        return Math.max(maxLength,charactersSoFar.size());
        return charactersSoFar.size();
    }
}