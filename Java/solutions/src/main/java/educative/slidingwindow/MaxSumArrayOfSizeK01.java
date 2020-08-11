package educative.slidingwindow;

public class MaxSumArrayOfSizeK01 {
    public static void main(String[] args) {
        int result = MaxSumArrayOfSizeK01.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 });
        System.out.println(" Max Sum of SubArray: " + result);

    }



    private static int findMaxSumSubArray(int k,int[] input){
        int result=Integer.MIN_VALUE;
        int start,end,sum;
        start=end=sum=0;

        while(end<input.length-1){
            sum+=input[end++];
            if(end >= k){
                System.out.println("Checking range "+start+":"+(end-1)+" "+sum);
                result=Math.max(result,sum);
                sum -=input[start++];
            }
           // end++;
        }

        return result;
    }


}
