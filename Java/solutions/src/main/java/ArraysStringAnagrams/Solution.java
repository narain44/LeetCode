package ArraysStringAnagrams;

import java.util.*;

public class Solution {
    public static void main(String [] args){
        Solution instance=new Solution();
        System.out.println("Anagrams are"+instance.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
//        System.out.println("Anagrams are"+instance.groupAnagrams(new String[]{"duh", "ill"}));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> wordHashValMap=new HashMap<>();
        for(String s:strs){
            String hash=hash(s);
            List<String> anagramSet=wordHashValMap.getOrDefault(hash,new ArrayList<String>());
            anagramSet.add(s);
            wordHashValMap.put(hash,anagramSet);
        }

        List<List<String>> result=new ArrayList<>();
        for(List<String> list:wordHashValMap.values()){
            result.add(list);
        }
        return result;
    }
    private String hash(String s){
        char[] charArray=s.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }
}
