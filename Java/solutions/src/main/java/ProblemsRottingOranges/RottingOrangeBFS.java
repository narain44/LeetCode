package ProblemsRottingOranges;



import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOrangeBFS {
    public static void main(String[] args) {
        System.out.println("Rotting Oranges");
        int[][] orangeMapReturns4 = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };


        int[][] orangeMapReturnsNeg1 = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };

        int[][] orangeMapReturns2={
                {2,1,1},
                {1,1,0},
                {2,1,1}
        };
        RottingOrangeBFS rottingOrangeBFS = new RottingOrangeBFS();
        //System.out.println("Number Minutes to ROT : " + rottingOrangeBFS.orangesRotting(orangeMapReturns4));

        System.out.println("Number Minutes to ROT : " + rottingOrangeBFS.orangesRotting(orangeMapReturnsNeg1));

        System.out.println("Number Minutes to ROT : " + rottingOrangeBFS.orangesRotting(orangeMapReturns2));
    }

    public int orangesRotting(int[][] grid) {
        Queue<Integer> queue = new ArrayDeque();

        // Step 1). build the initial set of rotten oranges
        int freshOranges = 0;
        int ROWS = grid.length, COLS = grid[0].length;

        for (int r = 0; r < ROWS; ++r) {
            for (int c = 0; c < COLS; ++c) {
                if (grid[r][c] == 2) {
                    queue.offer(r*COLS+c);
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }

        // Mark the round / level, _i.e_ the ticker of timestamp
        queue.offer(-1*COLS-1);

        // Step 2). start the rotting process via BFS
        int minutesElapsed = -1;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            Integer id = queue.poll();
            int row = id/COLS;
            int col = id%COLS;
            if (row == -1) {
                // We finish one round of processing
                minutesElapsed++;
                // to avoid the endless loop
                if (!queue.isEmpty()) {
                    queue.offer(-1*COLS-1);
                }
            } else {
                // this is a rotten orange
                // then it would contaminate its neighbors
                for (int[] d : directions) {
                    int neighborRow = row + d[0];
                    int neighborCol = col + d[1];
                    if (neighborRow >= 0 && neighborRow < ROWS && neighborCol >= 0 && neighborCol < COLS ) {
                        if (grid[neighborRow][neighborCol] == 1) {
                            // this orange would be contaminated
                            grid[neighborRow][neighborCol] = 2;
                            freshOranges--;
                            // this orange would then contaminate other oranges
                            queue.offer(neighborRow*COLS+neighborCol);
                        }
                    }
                }
            }
        }

        // return elapsed minutes if no fresh orange left
        return freshOranges == 0 ? minutesElapsed : -1;
    }


}
