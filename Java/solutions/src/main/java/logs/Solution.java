package logs;

import java.util.Arrays;

public class Solution {
    public static void main(String []args){
        Solution instance=new Solution();
        //String[] logs={"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};

        String[] logs={"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        String[] results= instance.reorderLogFiles(logs);
        for(String s:results){
            System.out.print(s+" ");
        }
        results= instance.reorderLogFiles(logs);
        System.out.println("OfficialSolution :");
        for(String s:results){
            System.out.print(s+" ");
        }
    }
    public String[] reorderLogFilesOfficialSolution(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if(!isDigit1 && !isDigit2) {
                // both letter-logs.
                int comp = split1[1].compareTo(split2[1]);
                if (comp == 0) return split1[0].compareTo(split2[0]);
                else return comp;
            } else if (isDigit1 && isDigit2) {
                // both digit-logs. So keep them in original order
                return 0;
            } else if (isDigit1 && !isDigit2) {
                // first is digit, second is letter. bring letter to forward.
                return 1;
            } else {
                //first is letter, second is digit. keep them in this order.
                return -1;
            }
        });
        return logs;
    }

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
}
