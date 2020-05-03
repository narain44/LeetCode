First Unique Character in a String
```
Given a string, find the first non-repeating character in it and return it's index. 
If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
```

Solution
```
public int findUniqueCharacter(String s){

  Map<Character,Integer> charCountMap=new Hashmap<>();
  //First Pass, build HashMap
  for(int i=0;i<s.length();i++){
    Character c=s.charAt(i);
    charCountMap.put(c,charCountMap.getOrDefault(c,0)+1);
  }
  
  //Second Pass, Check in the hash map
  for(int i=0;i<s.length();i++){
    Character c=s.charAt(i);
    if(charCountMap.get(c) == 1){
      return i;
  }
  return -1
}
```
---
1. Time Complexity - O(N) + O(N) for two loops ==> O(N)
2. Space Complexity - O(N) for the map that holds the count


