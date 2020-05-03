package mock1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String [] args){
        int[][] orangeMap={
                {2,1,1},
                {1,1,0},
                {2,1,1}
        };
        Solution instance =new Solution();
        System.out.println("Number of  minutes to ROT "+instance.orangesRotting(orangeMap));
    }
    public int orangesRotting(int[][] grid) {
        int totalRows=grid.length;
        int totalColumns=grid.length;
        int totalMinutes = 0;
        Queue<Integer> badOrange=new LinkedList<Integer>();
        int totalOranges=0;
        for(int r=0;r<totalRows;r++){
            for(int c=0;c<totalColumns;c++){
                if(grid[r][c]==1){
                    totalOranges++;
                } else if(grid[r][c]== 2){
                    badOrange.offer(r*totalColumns+c);
                }
            }
        }
        int rootOrangeIndex=0*totalColumns+0;
        badOrange.add(rootOrangeIndex);
        badOrange.add(-12); // TO Keep Track of bottom
        totalMinutes++;

        while(!badOrange.isEmpty()){
            int orangeIndicator=badOrange.poll();
            int row=orangeIndicator/totalColumns;
            int column=orangeIndicator%totalColumns;
            if(orangeIndicator == -12){
                if(!badOrange.isEmpty()) {
                    badOrange.add(-12);
                    totalMinutes++;
                }
            }else{
                grid[row][column]=0;
               // totalOranges--;
                if(row-1 >=0 && grid[row-1][column] == 1) {
                    int orangeIndex = (row - 1) * totalColumns + column;
                    badOrange.add(orangeIndex);
                    totalOranges--;
                    grid[row - 1][column] = 0;
                }
               if(column-1 >=0 && grid[row][column-1] == 1){
                    int orangeIndex=(row)*totalColumns+(column-1);
                    badOrange.add(orangeIndex);
                    totalOranges--;
                    grid[row][column-1] = 0;
               }
               if(row+1 < totalRows && grid[row+1][column] == 1){
                    int orangeIndex=(row+1)*totalColumns+column;
                    badOrange.add(orangeIndex);
                    totalOranges--;
                    grid[row+1][column] = 0;
               }
               if(column+1 <totalColumns && grid[row][column+1] == 1){
                    int orangeIndex=(row)*totalColumns+(column+1);
                    badOrange.add(orangeIndex);
                    totalOranges--;
                    grid[row][column+1] = 0;
               }
            }
        }


        return totalOranges == 0 ?totalMinutes-1:-1;

    }
}