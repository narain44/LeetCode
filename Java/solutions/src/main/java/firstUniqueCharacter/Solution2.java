package firstUniqueCharacter;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public int findUniqueCharacter(String s) {

        Map<Character, Integer> charCountMap = new HashMap<>();
        //First Pass, build HashMap
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        //Second Pass
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (charCountMap.get(c) == 1) {
                return i;
            }

        }
        return -1;
    }
}
