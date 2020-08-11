package TreeTreasureIsland;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionBFSPractice {
    public static void main(String[] args) {
        char[][] terrain = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        SolutionBFSPractice solutionBFS = new SolutionBFSPractice();
        int numberOfIslands = solutionBFS.numIslands(terrain);
        System.out.println("Number Of islands : " + numberOfIslands);

//        char[][] terrain2 = {
//                {'1', '1', '0', '0', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '0'},
//                {'0', '0', '0', '1', '1'}
//        };
//        numberOfIslands = solutionBFS.numIslands(terrain2);
//        System.out.println("Number Of islands in Terrain 2: " + numberOfIslands);
    }

    public int numIslands(char[][] grid) {

        int numOfIslands=0;
        int R=grid.length;int C=grid[0].length;
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]=='1'){
                    numOfIslands++;
                    Queue<Integer> queue=new LinkedList<>();
                    queue.add(r*C+c);
                    while(!queue.isEmpty()){

                        int agRC=queue.poll();
                        int cr=agRC/C;
                        int cc=agRC%C;
                        System.out.println("Checking"+cr+","+cc);
                        if(cr<0 ||cr>=R||cc<0||cc>=C||grid[cr][cc] == '0') continue;

                        grid[cr][cc] ='0';
                        queue.add((cr-1)*C+cc);
                        queue.add((cr+1)*C+cc);
                        queue.add(cr*C+(cc-1));
                        queue.add(cr*C+(cc+1));

                    }
                }
            }
        }

        return numOfIslands;
    }

//    public int numIslands(char[][] grid) {
//        if (grid == null || grid.length == '0') {
//            return '0';
//        }
//
//        int nr = grid.length;
//        int nc = grid[0].length;
//        int num_islands = 0;
//
//        for (int r = 0; r < nr; ++r) {
//            for (int c = 0; c < nc; ++c) {
//                if (grid[r][c] == '1') {
//                    ++num_islands;
//                    grid[r][c] = '0'; // mark as visited
//                    Queue<Integer> neighbors = new LinkedList<>();
//                    neighbors.add(r * nc + c);
//                    while (!neighbors.isEmpty()) {
//                        int id = neighbors.remove();
//                        int row = id / nc;
//                        int col = id % nc;
//                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
//                            neighbors.add((row - 1) * nc + col);
//                            grid[row - 1][col] = '0';
//                        }
//                        if (row + 1 < nr && grid[row + 1][col] == '1') {
//                            neighbors.add((row + 1) * nc + col);
//                            grid[row + 1][col] = '0';
//                        }
//                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
//                            neighbors.add(row * nc + col - 1);
//                            grid[row][col - 1] = '0';
//                        }
//                        if (col + 1 < nc && grid[row][col + 1] == '1') {
//                            neighbors.add(row * nc + col + 1);
//                            grid[row][col + 1] = '0';
//                        }
//                    }
//                }
//            }
//        }
//        return num_islands;
//    }
}
