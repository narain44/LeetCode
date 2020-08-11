package educative.slidingwindow;

public class SmallestSubArrayWithGivenSum02 {
    public static int findMinSubArray(int S, int[] arr) {
        int windowSum = 0, minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // shrink the window as small as possible until the 'windowSum' is smaller than 'S'
            while (windowSum >= S) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static int findMinSubArrayMine(int S, int[] arr) {
        int result=Integer.MAX_VALUE;
        int start=0,end=0;
        int sumSoFar=0;
        while(start < arr.length){
            if(sumSoFar >= S){
                result=Math.min( (end-start)+1,result);
                //System.out.println("Start: "+start+" End: "+end+" Result: " +result);
                sumSoFar -=arr[start++];
            }else if(end >= arr.length){
                break;
            }else{
                sumSoFar +=arr[end++];
            }
        }
        return result;
    }


    public static int findMinSubArrayNew(int S, int[] arr) {
        int result=Integer.MAX_VALUE;
        int start=0,sumSoFar=0;
        for(int end=0;end<arr.length;end++){
            sumSoFar+=arr[end];
            while(sumSoFar>=S && start<=end){
                result=Math.min(result,(end-start+1));
                sumSoFar=sumSoFar-arr[start];
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int result = SmallestSubArrayWithGivenSum02.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);

//        result = SmallestSubArrayWithGivenSum02.findMinSubArrayMine(7, new int[] { 2, 1, 5, 2, 3, 2 });
//        System.out.println("Smallest subarray length: " + result);

        result = SmallestSubArrayWithGivenSum02.findMinSubArrayNew(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);

        result = SmallestSubArrayWithGivenSum02.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);

        result = SmallestSubArrayWithGivenSum02.findMinSubArrayNew(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);

    }
}
