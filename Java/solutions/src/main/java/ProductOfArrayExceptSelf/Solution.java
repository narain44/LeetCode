package ProductOfArrayExceptSelf;

import java.util.Arrays;

public class Solution {
    public static void main(String []args){
        Solution instance=new Solution();
        System.out.println(Arrays.toString(instance.productExceptSelf(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(instance.productExceptSelfSpaceOptimized(new int[]{1,2,3,4})));
    }

    //O(N) time and O(N) space
    public int[] productExceptSelf(int[] nums) {
        int [] lProduct=new int[nums.length];
        int [] rProduct=new int[nums.length];
        int [] answer=new int[nums.length];
        //Build a Left Array
        lProduct[0]=1;
        for(int i=1;i<nums.length;i++){
            lProduct[i]=lProduct[i-1]*nums[i-1];
        }

        //Build a Right Array
        rProduct[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--){
            rProduct[i]=rProduct[i+1]*nums[i+1];
        }

        for(int i=0;i<nums.length;i++){
            answer[i]=lProduct[i]*rProduct[i];
        }
        return answer;
    }

    //O(N) time and O(1) space
    public int[] productExceptSelfSpaceOptimized(int[] nums) {
        int [] answer=new int[nums.length];
        //Build a Left Array
        answer[0]=1;
        for(int i=1;i<nums.length;i++){
            answer[i]=answer[i-1]*nums[i-1];
        }

        int R=1;
        for(int i=nums.length-1;i>=0;i--){
            answer[i]=answer[i]*R;
            R = R*nums[i];
        }
        return answer;
    }
}
