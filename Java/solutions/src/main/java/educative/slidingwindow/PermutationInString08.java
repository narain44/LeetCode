package educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString08 {
    public static void main(String []args){
        System.out.println("String : oidbcaf Pattern: abc found "+findPermutation("oidbacaf","abac"));
    }

    public static boolean findPermutation(String str, String pattern) {
        Map<Character,Integer> patternMap=new HashMap<>();
        for(Character c:pattern.toCharArray()){
            patternMap.put(c,patternMap.getOrDefault(c,0)+1);
        }

        Map<Character,Integer> inputStrMap=new HashMap<>();
        for(int i=0;i<str.length();i++){
            Character c=str.charAt(i);
            if(patternMap.keySet().contains(c)){
                inputStrMap.put(c,inputStrMap.getOrDefault(c,0)+1);
                if(patternMap.keySet().size() == inputStrMap.keySet().size()) {
                    boolean countMatch=true;
                    for(Character checkChar:patternMap.keySet()){
                        if(patternMap.get(checkChar) != inputStrMap.get(checkChar)){
                            countMatch=false;
                            break;
                        }
                    }
                    if (countMatch) return true;
                }
            }else{
                inputStrMap=new HashMap<>();
                continue;
            }
        }
        return false;
    }
}
