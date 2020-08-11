package educative.twopointers;

import java.util.Arrays;

public class PairWithTargetSum01 {

    public static void main(String[] args){
        System.out.println("[2,3,5,7,8,45] target: 12 : "+ Arrays.toString(search(new int[]{2,3,5,7,8,45},12)));
    }
    public static int[] search(int[] arr, int targetSum) {
        int left=0,right=arr.length-1;
        while(left<right){
            int currentSum=arr[left]+arr[right];
            if(currentSum == targetSum) return new int[]{left,right};
            else if(currentSum > targetSum) right--;
            else left++;
        }
        return new int[] { -1, -1 };
    }
}
