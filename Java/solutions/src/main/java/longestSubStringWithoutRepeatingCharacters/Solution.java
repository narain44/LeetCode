package longestSubStringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String []args){
        Solution instance=new Solution();
        System.out.println(instance.lengthOfLongestSubstring("abscdd"));
    }
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}