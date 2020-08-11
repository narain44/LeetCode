package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class BackTrackingFindAllSubsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        BackTrackingFindAllSubsets instance = new BackTrackingFindAllSubsets();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = instance.subsets(nums);
        for (List<Integer> permutation : result) {
            System.out.println(permutation.toString());
        }
        System.out.println(result.size());

        if(1<0 || 5>3 && 25>5)
            System.out.println("1<2 || 5>3 && 25>50 is true");

    }
}
