```
You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.

 

Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
```
Constraints:

0 <= logs.length <= 100
3 <= logs[i].length <= 100
logs[i] is guaranteed to have an identifier, and a word after the identifier.

Solution
---   
```
public String[] reorderLogFiles(String[] logs) {
        Arrays.Sort(logs,new Comparator(log1,log2) ->{
          String log1Words=log1.split(" ");
          String log2Words=log2.split(" ");
          String log1IsDigit=Character.isDigit(log1[1].charAt(0));
          String log2IsDigit=Character.isDigit(log2[1].charAt(0));
          
          //Check if both logs are alphabets
          if(!log1IsDigit && !log2IsDigit){
            int cmp=log1[1].compareTo(log2[1]); //Compare first log entry
            if ( cmp == 0 ) return log1[0].compareTo(log2[0]); //If first log entry is equal, compare id's
            return cmp; //Else return the comparision results
          }else if(!log1IsDigit){ //First log is word, so it should come before the secone one
            return -1;
          }else{ //Second log is word, so it should come before the first one
            return 1;
          }
          
        });
        return logs;
}
```

```
   public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,(log1,log2) ->{
          String[] log1Words=log1.split(" ");
          String[] log2Words=log2.split(" ");
          boolean log1IsDigit=Character.isDigit(log1Words[1].charAt(0));
          boolean log2IsDigit=Character.isDigit(log2Words[1].charAt(0));
          
          //Check if both logs are alphabets
          if(!log1IsDigit && !log2IsDigit){
            int cmp=log1Words[1].compareTo(log2Words[1]); //Compare first log entry
             if (cmp != 0) return cmp;
            return log1Words[0].compareTo(log2Words[0]);
            //if ( cmp == 0 ) return log1Words[0].compareTo(log2Words[0]); //If first log entry is equal, compare id's
           // return cmp; //Else return the comparision results
          }
         return log1IsDigit ? (log2IsDigit ? 0 : 1) : -1;
          // else if(!log1IsDigit){ //First log is word, so it should come before the secone one
          //   return -1;
          // }else{ //Second log is word, so it should come before the first one
          //   return 1;
          // }
          
        });
        return logs;
    }
   ```
