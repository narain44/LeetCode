package ld.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;
//import org.junit.Test;
//import static org.junit.Assert.*;



public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,13,5,11};
        int[] result=new Solution().twoSum(nums,9);
        System.out.println(result);
        //assertArrayEquals(expectedOutput, methodOutput);

    }
}


class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> valueIndexMap=new HashMap<Integer,Integer>();
        for(int index=0;index<nums.length;index++){
            int value=nums[index];
            int valueToSearch=target-value;
            if(valueIndexMap.get(valueToSearch)!=null){
                return new int[]{valueIndexMap.get(valueToSearch),index};
            }else{
                valueIndexMap.put(value,index);
            }
            //  for(int innerIndex=index+1;innerIndex<nums.length;innerIndex++){
            //      if(nums[index]+nums[innerIndex] == target){
            //          return new int[]{index,innerIndex};
            //      }
            //  }
            // // System.out.println("Num "+nums[index]);
        }
        return null;
    }
}

