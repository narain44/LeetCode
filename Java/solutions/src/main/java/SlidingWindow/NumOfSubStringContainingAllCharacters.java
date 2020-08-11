package SlidingWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumOfSubStringContainingAllCharacters {

    public static void main(String [] args){
        NumOfSubStringContainingAllCharacters instance=new NumOfSubStringContainingAllCharacters();
        System.out.println(instance.numberOfSubstrings("abcabc"));
    }

    public int numberOfSubstrings(String s) {
        int count[] = {0, 0, 0}, res = 0 , i = 0, n = s.length();
        for (int j = 0; j < n; ++j) {
            ++count[s.charAt(j) - 'a'];
            while (count[0] > 0 && count[1] > 0 && count[2] > 0)
                --count[s.charAt(i++) - 'a'];
            res += i;
        }
        return res;
    }

    public int numberOfSubstringsMine(String s) {
        Set<Character> seen=new HashSet<Character>();
        List<Character> seenSoFar=new ArrayList<Character>();
        int result=0;
        for(int i=0;i<s.length();i++){
            Character c=s.charAt(i);
            seen.add(c);
            if(seen.size() == 3){
                result+=s.length()-i;
                result+=seenSoFar.size();
                seen=new HashSet<Character>();
                seenSoFar=new ArrayList<Character>();
                seen.add(c);
            }
            seenSoFar.add(c);

        }
        return result;
    }
}

