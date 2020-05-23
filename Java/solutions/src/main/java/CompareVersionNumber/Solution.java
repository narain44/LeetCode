package CompareVersionNumber;

public class Solution {
    public static void main(String []args){
        Solution instance=new Solution();
        System.out.println( "1.0.0.1"+"1.0.0.0 -->"+instance.compareVersion("1.0.0.1","1.0.0.0"));
        System.out.println( "2.0"+"2.0.1 -->"+instance.compareVersion("2.0","2.0.1"));
    }
    public int compareVersion(String version1, String version2) {
        String[] version1Split=version1.split("\\.");
        String[] version2Split=version2.split("\\.");
        int maxIndex=Math.max(version1Split.length,version2Split.length);
        for(int i=0;i<maxIndex;i++){
            int str1IntVal=0;
            int str2IntVal=0;
            if(i<version1Split.length)
                str1IntVal=Integer.parseInt(version1Split[i]);
            if(i<version2Split.length)
                str2IntVal=Integer.parseInt(version2Split[i]);
            int comparision=Integer.compare(str1IntVal,str2IntVal);
            if(comparision != 0) return comparision;
        }
        return 0;
    }
}
