package SortingAndSearchingKthLargest;

import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1,i2) ->(i2-i1));
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k)
                pq.poll();
        }
        System.out.println(k+" th/rd largest element is "+ pq.peek());
        return pq.poll();
    }

    public static void main(String [] args){
        int [] arrayToFind = new int[]{1,2,3,4,5,6,7,8,9};
        new Solution().findKthLargest(arrayToFind,5);
    }
}
