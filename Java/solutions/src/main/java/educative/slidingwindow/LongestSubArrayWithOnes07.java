package educative.slidingwindow;

public class LongestSubArrayWithOnes07 {
    public static void main(String []args){
        System.out.println("Result for array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2 " +findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1},2)); //6
        System.out.println("Result for array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3 " +findLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1},3)); //9
    }
    public static int findLength(int[] arr, int k) {
        // TODO: Write your code here
        //1.Keep track of 1's count in current window
        //2. if(end-start+1-1'scount>k){
        //3. if arr[start] == 1, reduce 1's count
        //4. start++
        // 5.} calculate length

        int start=0,result=0,onesCount=0;
        for(int end=0;end<arr.length;end++){
            if(arr[end] == 1) onesCount++;
            if((end-start+1) - onesCount > k){
                if(arr[start] == 1) onesCount --;
                start++;
            }
            result=Math.max(result,end-start+1);
        }
        return result;
    }
}
