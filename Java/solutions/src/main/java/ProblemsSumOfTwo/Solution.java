package ProblemsSumOfTwo;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String []args){
        Solution instance=new Solution();
        int[] nums=new int[] {2, 7, 11, 15};
        int target=9;
        instance.twoSum(nums,target);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> complementMap=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if(complementMap.get(complement) !=null){
                return new int[]{complementMap.get(complement),i};
            }else{
                complementMap.put(nums[i],i);
            }
        }

        return null;
    }

}
