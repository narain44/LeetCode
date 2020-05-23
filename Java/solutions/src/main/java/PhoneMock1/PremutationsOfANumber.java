package PhoneMock1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PremutationsOfANumber {

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> numsList=new ArrayList<>();
        Set<String> set=new HashSet<>();
        for(int i:nums){
            numsList.add(i);
        }
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<numsList.size();i++) {
            ArrayList<Integer> perumationList = new ArrayList<>();
            for (int j = 0; j < numsList.size(); j++) {
                if (j == i) continue;
                perumationList.add(nums[j]);
            }

            for (int k = 0; k <= perumationList.size(); k++) {
                ArrayList<Integer> perumationListCopy = (ArrayList<Integer>) perumationList.clone();
                perumationListCopy.add(k, nums[i]);
                StringBuffer perumationListCopyString = new StringBuffer();
                for (int item : perumationListCopy) {
                    perumationListCopyString.append(item + "");
                }
                if (set.contains(perumationListCopyString.toString())) continue;
                else {
                    result.add(perumationListCopy);
                    set.add(perumationListCopyString.toString());
                }
            }
        }
        return result;
//        List<List<Integer>> distinctResult=new ArrayList<>();
//        for(List<Integer> p:result){
//            if(set.contains(p)) continue;
//            distinctResult.add(p);
//        }
//        return distinctResult;
    }


    public static void main(String [] args){
        PremutationsOfANumber instance=new PremutationsOfANumber();
        int [] nums=new int[]{1,2,3};
        List<List<Integer>> result=instance.permute(nums);
        for(List<Integer> permutation:result){
            System.out.println(permutation.toString());
        }
        System.out.println(result.size());

    }
}
