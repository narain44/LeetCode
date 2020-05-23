package SortingAndSearchingMeetingRooms2;

import java.util.Arrays;
import java.util.LinkedList;

public class MeetingRooms2 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->Integer.compare(a[0],b[0]));

        LinkedList<int[]> merged = new LinkedList<>();
        int roomCount=1;
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        MeetingRooms2 instance = new MeetingRooms2();
        //int[][] testCase1=new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] testCase1=new int[][]{{0,30},{5,10},{15,20}};
        int[][] result=instance.merge(testCase1);
        System.out.println(Arrays.deepToString(result));
    }

}

