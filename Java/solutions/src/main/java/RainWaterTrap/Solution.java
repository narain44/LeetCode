package RainWaterTrap;

public class Solution {
    public int trap(int[] height) {
        int length=height.length;
        int [] lMax = new int[length];
        int [] rMax = new int[length];

        lMax[0]=height[0];
        rMax[length-1]=height[length-1];

        //Fill lMax and rMax
        for(int i=1;i<length;i++){
            lMax[i] = Math.max(height[i],lMax[i-1]);
        }

        for(int i=length-2;i>=0;i--){
            rMax[i] = Math.max(height[i],rMax[i+1]);
        }

        int answer=0;
        for(int i=0;i<length;i++){
            answer += Math.min(lMax[i],rMax[i])-height[i];
        }
        return answer;
    }

    public static void main(String []args){
        int[] height=new int [] {0,1,0,2,1,0,1,3,2,1,2,1};
        new Solution().trap(height);
    }
}
