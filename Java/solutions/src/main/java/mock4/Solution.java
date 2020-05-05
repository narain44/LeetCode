package mock4;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s = "ba";
        int k = 1;
        Solution instance = new Solution();
        System.out.println("Answer is " + instance.reverseStr(s, k));
    }

    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }

//    public String reverseStr(String s, int k) {
//        StringBuffer answer = new StringBuffer();
//        int startIndex =0;
//        int endIndex = (k*2)-1;
//
//        while(startIndex+k < s.length()){
//            processBlock(s,startIndex,k);
//            startIndex=startIndex+(k*2);
//        }
//
//
//    }
//
//    private String processBlock(String s,int startIndex,int k){
//        int count=0;
//        StringBuffer sb=new StringBuffer();
//        String returnValue="";
//        returnValue.rev
//        while(startIndex<=startIndex+((k*2)-1)){
//            if(count==k){
//
//            }
//        }
//    }
}
