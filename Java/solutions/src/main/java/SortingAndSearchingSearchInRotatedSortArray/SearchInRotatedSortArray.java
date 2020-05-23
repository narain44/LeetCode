package SortingAndSearchingSearchInRotatedSortArray;


public class SearchInRotatedSortArray {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length <1) return -1;
        return binarySearch(nums,0,nums.length-1,target);
    }

    private int binarySearch(int[] nums,int start,int end,int target){
        if(start==end) { //BaseCase
            if (nums[start] == target)
                return start;
        }else if(start<end){
            int mid=(start+end)/2;
            int left=binarySearch(nums,start,mid,target);
            int right=binarySearch(nums,mid+1,end,target);
            if(left !=-1) return left;
            else if(right !=-1) return right;
        }
        return -1;

    }


    public static void main(String[] args) {
        SearchInRotatedSortArray instance = new SearchInRotatedSortArray();
      //  int[] num1 = new int[]{4,5,6,7,0,1,2};

        int[] num1 = new int[]{266, 267, 268, 269, 271, 278, 282, 292, 293, 298, 6, 9, 15, 19, 21, 26, 33, 35, 37, 38, 39, 46, 49, 54, 65, 71, 74, 77, 79, 82, 83, 88, 92, 93, 94, 97, 104, 108, 114, 115, 117, 122, 123, 127, 128, 129, 134, 137, 141, 142, 144, 147, 150, 154, 160, 163, 166, 169, 172, 173, 177, 180, 183, 184, 188, 198, 203, 208, 210, 214, 218, 220, 223, 224, 233, 236, 241, 243, 253, 256, 257, 262, 263};
        int target = 208;
        System.out.println(instance.search(num1, target));
    }
}
