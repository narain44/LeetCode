package KClosestPointToOrigin;

import java.util.Arrays;

/**
 * Time complexity O(n)+O(n log(n))+O(n) = O(n log(n))
 *
 * Space Complexity O(n)+O(k) =
 */
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int numberOfPoints=points.length;
        int[] distances =new int[numberOfPoints];
        //Calculate the distances for each point and stores in distances array in the same order it was received.
        //O(n)
        for(int i=0;i<numberOfPoints;i++){
            distances[i] = calculateDistance(points[i]);
        }

        //Sort the distances
        //O(n log(n))
        Arrays.sort(distances);

        int maxThreshHoldDistance=distances[K-1];
        int [][] answerArray = new int[K][];
        int answerArrayIndex=0;
        //O(n)
        for(int i=0;i<numberOfPoints;i++){
            if(answerArrayIndex<K && calculateDistance(points[i]) <= maxThreshHoldDistance){
                answerArray[answerArrayIndex] =points[i];
                answerArrayIndex++;
            }
        }
        System.out.println("Answer is \n"+Arrays.deepToString(answerArray));
        return answerArray;
    }

    private int calculateDistance(int [] point){
        return (point[0]*point[0])+ (point[1]*point[1]);
    }

    public static void main(String []args){
        int[] singlePoints = new int[]{1,3};
        int[][] blankpoints = new int[2][];
        int[][] points = {
                {1,3},
                {-2,2}};
        System.out.print(points[0][0]+",");
        System.out.println(points[0][1]);
        System.out.print(points[1][0]+",");
        System.out.println(points[1][1]);
        new Solution().kClosest(points,1);

        int[][] pointsTestCase1 = {
                {3,3},
                {5,-1},
                {-2,4}};
        new Solution().kClosest(pointsTestCase1,2);
    }
}