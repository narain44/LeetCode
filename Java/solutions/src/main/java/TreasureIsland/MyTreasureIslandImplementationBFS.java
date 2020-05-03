package TreasureIsland;

import java.util.LinkedList;
import java.util.Queue;

public class MyTreasureIslandImplementationBFS {
    public static void main(String[] args) {
        System.out.println("Rotting Oranges");
        char[][] terrain = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        MyTreasureIslandImplementationBFS myTreasureIslandImplementationBFS = new MyTreasureIslandImplementationBFS();
        int numberOfIslands = myTreasureIslandImplementationBFS.numIslands(terrain);
        System.out.println("Number Of islands : " + numberOfIslands);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int numberOfIslands = 0;
        int NR = grid.length;
        int NC = grid[0].length;
        Queue<Integer> neighbors = new LinkedList<>();
        for (int r = 0; r < NR; r++) {
            for (int c = 0; c < NC; c++) {
                if(grid[r][c] == '1') {
                    ++numberOfIslands;
                    grid[r][c] = '0';
                    Integer neighbor = r * NC + c;
                    neighbors.add(neighbor);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.poll();
                        int row=id/NC;
                        int column= id % NC;
                        if (row - 1 >= 0 && grid[row - 1][column] == '1') {
                            grid[row - 1][column] = '0';
                            neighbor = (row - 1) * NC + column;
                            neighbors.add(neighbor);
                        } else if (column - 1 >= 0 && grid[row][column - 1] == '1') {
                            grid[row][column - 1] = '0';
                            neighbor = (row * NC) + (column - 1);
                            neighbors.add(neighbor);
                        } else if (row + 1 < NR && grid[row+1][column] == '1') {
                            grid[row + 1][column] = '0';
                            neighbor = ((row + 1) * NC) + column;
                            neighbors.add(neighbor);
                        } else if (column + 1 < NC && grid[row][c + 1] == '1') {
                            grid[row][c+1] = '0';
                            neighbor = (row) * NC + (c+1);
                            neighbors.add(neighbor);
                        }
                    }
                }
            }
        }
        return numberOfIslands;
    }


}
