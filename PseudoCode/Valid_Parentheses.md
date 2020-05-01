```
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
```

public class Solution(){
   //Map to hold the pairs of parenthesis
    Map<Character, Character> mappings;

    //Default Constructor, initialize mappings
    public Solution() {
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

