package SortingAndSearchingMergeIntervals;

import java.util.Arrays;

public class MergeIntervals {


    public int[][] merge(int[][] intervals) {
        if(intervals == null ) return null;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int[][] result = new int[intervals.length][2];
        int rsIndex=0;
        int[] currentPair = intervals[0];
        int start=currentPair[0];int end=currentPair[1];
        for(int i=0;i<intervals.length;i++){
            if(i<intervals.length-2){
                int[] nextPair=intervals[i+1];
            }



            result[rsIndex++]=new int[]{start,end};

            i++;
        }

        return Arrays.copyOfRange(result,0,rsIndex);
    }

    public static void main(String[] args) {
        MergeIntervals instance = new MergeIntervals();
        int[][] testCase1=new int[][]{{1,3},{2,6},{8,10},{15,18}};
//        int[][] testCase1=new int[][]{{1,4},{4,5}};
        int[][] result=instance.merge(testCase1);
        System.out.println(Arrays.deepToString(result));
    }
}
