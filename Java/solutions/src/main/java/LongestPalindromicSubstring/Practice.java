package LongestPalindromicSubstring;

public class Practice {
    public static void main(String []args){
        Practice solution=new Practice();
        String stringtoTest="babad";
        String longestPalindrome=solution.longestPalindrome(stringtoTest);
        System.out.println("Longest Palindrome in \n"+stringtoTest+"\nis\n"+longestPalindrome);
    }
    public String longestPalindrome(String s) {
        if(s== null || s.length() == 0) return s;
        int start=0,end=0;

        for(int i=0;i<s.length();i++){
            int leftLen=computeLen(s,i,i);
            int rightLen=computeLen(s,i,i+1);
            int len=Math.max(leftLen,rightLen);

            if(len> (end-start)){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }

        return s.substring(start,end+1);
    }


    private int computeLen(String s,int j,int k){
        while(j>=0 && k<s.length() && s.charAt(j) == s.charAt(k)){
            j--;
            k++;
        }
        return k-j-1;
    }
}
