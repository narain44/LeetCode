package vaildparantheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution2 {
    //Map to hold the pairs of parenthesis
    Map<Character, Character> mappings;

    //Default Constructor, initialize mappings
    public Solution2() {
        mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
    }

    public boolean isValid(String s) {
        //Edge Case
        if (s.length() == 0) return true;

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            //Check if this is a closing parenthesis
            if (mappings.get(c) != null) {
                Character topOfStackChar = stack.isEmpty()? '#' :stack.pop();
                if (topOfStackChar != mappings.get(c)) {
                    return false;
                }
            } else {//Just push this to stack
                if(mappings.containsValue(c)) {
                    stack.push(c);
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}