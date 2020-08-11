package logs;

import java.util.Arrays;

public class Practice {

    public static void main(String []args){
        Practice instance=new Practice();
        System.out.println("Expected\n"+"g1 act car "+"a8 act zoo ");
        System.out.println("\nMy Solution :");
        String[] logs={"g1 act car","a8 act zoo"};
        String[] results= instance.reorderLogFiles(logs);
        for(String s:results){
            System.out.print(s+" ");
        }

        String[] logsOffical={"g1 act car","a8 act zoo"};
        String[] result1= instance.reorderLogFilesOfficialSolution(logsOffical);
        System.out.println("\nOfficialSolution :");
        for(String s:result1){
            System.out.print(s+" ");
        }
    }

    public String[] reorderLogFilesOfficialSolution(String[] logs) {

        Arrays.sort(logs,(s1, s2) -> {
            String[] log1Split=s1.split("\\s");
            String[] log2Split=s2.split("\\s");
            Character log1Char=log1Split[1].charAt(0);
            Character log2Char=log2Split[1].charAt(0);
//
//            //Compare the characters
//            if(Character.isDigit(log1Char) && Character.isDigit(log2Char)){
//                return 0;
//            }else if(Character.isDigit(log1Char) ){
//                return 1;
//            }else if(Character.isDigit(log2Char) ){
//                return -1;
//            }else{
//                if(!log1Split[1].equals(log2Split[1])){
//                    return log1Split[1].compareTo(log2Split[1]);
//                }else{
//                    String id1=log1Split[0],id2=log2Split[0];
//                    if(id1.equals(id2)) return 0;
//                    else {
//                        return log1Split[0].compareTo(log2Split[0]);
//                    }
//                }
//            }
            return 0;
        });


        Arrays.sort(logs, (s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);

//            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
//            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
//
//            if(!isDigit1 && !isDigit2) {
//                // both letter-logs.
//                int comp = split1[1].compareTo(split2[1]);
//                if (comp == 0) return split1[0].compareTo(split2[0]);
//                else return comp;
//            } else if (isDigit1 && isDigit2) {
//                // both digit-logs. So keep them in original order
//                return 0;
//            } else if (isDigit1 && !isDigit2) {
//                // first is digit, second is letter. bring letter to forward.
//                return 1;
//            } else {
//                //first is letter, second is digit. keep them in this order.
//                return -1;
//            }
            return 0;
        });
        return logs;
    }


    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,(s1, s2) -> {
            String[] log1Split=s1.split("\\s");
            String[] log2Split=s2.split("\\s");
            Character log1Char=log1Split[1].charAt(0);
            Character log2Char=log2Split[1].charAt(0);

            //Compare the characters
            if(Character.isDigit(log1Char) && Character.isDigit(log2Char)){
                return 0;
            }else if(Character.isDigit(log1Char) ){
                return 1;
            }else if(Character.isDigit(log2Char) ){
                return -1;
            }else{
                if(!log1Split[1].equals(log2Split[1])){
                    return log1Split[1].compareTo(log2Split[1]);
                }else{
                    String id1=log1Split[0],id2=log2Split[0];
                    if(id1.equals(id2)) return 0;
                    else {
                        return log1Split[0].compareTo(log2Split[0]);
                    }
                }
            }
        });
        return logs;
    }
}
