package BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BackTrackingFindAllSubsetsPractice {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List numsList= new ArrayList();
        for(int i=0;i<nums.length;i++){
            numsList.add(nums[i]);
        }
        backtrack(numsList,0);
        return result;
    }

    private void backtrack(List<Integer> nums,int first){
        if(first == nums.size()){
            result.add(new ArrayList(nums));
        }
        for(int i=first;i<nums.size();i++){
            Collections.swap(nums,first,i);
            backtrack(nums,first+1);
            Collections.swap(nums,first,i);
        }
    }

    public static void main(String[] args) {
        BackTrackingFindAllSubsetsPractice instance = new BackTrackingFindAllSubsetsPractice();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = instance.permute(nums);
        System.out.println(result.size());
//        for (List<Integer> permutation : result) {
//            System.out.println();
//            for(Integer i:permutation)
//             System.out.print(i);
//        }

    }
}
