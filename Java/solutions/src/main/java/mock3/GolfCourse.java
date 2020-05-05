package mock3;

import RottingOranges.RottingOrangeDFS;

import java.util.*;

public class GolfCourse {
    public static void main(String[] args) {
        System.out.println("Golf Course tree");
        List<Integer> row1= Arrays.asList( new Integer [] {1,2,3});
        List<Integer> row2= Arrays.asList( new Integer [] {0,0,4});
        List<Integer> row3= Arrays.asList( new Integer [] {7,6,5});
        List<List<Integer>> course=new ArrayList<>();
        course.add(row1); course.add(row2); course.add(row3);
        GolfCourse instance = new GolfCourse();
        int numberOfIslands = instance.cutOffTree(course);
        System.out.println("Number Of Steps : " + numberOfIslands);
    }

    public int cutOffTree(List<List<Integer>> forest) {
        int[] treeHeights=new int[9];
        int i=0;
        for(List row:forest){
            for(Object treeHeight:row){
                if( (int)treeHeight >1 ){
                    treeHeights [i] = (int)treeHeight;
                    i++;
                }
            }
        }
        PriorityQueue<Integer> treeOrder=new PriorityQueue<>( (e1,e2) -> e2-e1);
        for(int j=0;j<treeHeights.length;j++){
            if(treeHeights[j] != 0){
                treeOrder.offer(treeHeights[j]);
            }
        }
        while (treeOrder.peek()!=null){
            System.out.println(treeOrder.poll());
        }
        return -1;
    }

}
