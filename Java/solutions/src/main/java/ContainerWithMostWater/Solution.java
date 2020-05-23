package ContainerWithMostWater;


public class Solution {
    public static void main(String [] args){
        Solution instance=new Solution();
        System.out.println("Max area is :"+instance.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    public int maxArea(int[] height) {
        if(height == null || height.length==0) return 0;

        int maxArea=0;
        int lIndex=0;
        int rIndex= height.length-1;
        while(lIndex<rIndex){
            int currentArea=Math.min(height[lIndex],height[rIndex]) * (rIndex-lIndex);
            maxArea = Math.max(maxArea,currentArea);
            if(height[lIndex]<height[rIndex])
                lIndex++;
            else
                rIndex--;
        }
        return maxArea;
    }
}
