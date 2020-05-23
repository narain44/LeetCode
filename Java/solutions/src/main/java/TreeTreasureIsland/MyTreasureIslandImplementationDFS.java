package TreeTreasureIsland;

public class MyTreasureIslandImplementationDFS {
    public static void main(String[] args) {
        System.out.println("Rotting Oranges");
        char[][] terrain = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        MyTreasureIslandImplementationDFS myTreasureIslandImplementationDFS = new MyTreasureIslandImplementationDFS();
        int numberOfIslands = myTreasureIslandImplementationDFS.numIslands(terrain);
        System.out.println("Number Of islands : " + numberOfIslands);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int numberOfIslands = 0;
        int NR = grid.length;
        int NC = grid[0].length;
        for (int i = 0; i < NR; i++) {
            for (int j = 0; j < NC; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands++;
                    dfs(grid,i,j);
                }
            }
        }
        return numberOfIslands;
    }

    private void dfs(char[][] grid, int row, int column) {
        if (row  < 0 || column < 0 || row >= grid.length || column >= grid[0].length || grid[row][column] == '0')
            return;
        grid[row][column] = '0';
        dfs(grid,row-1,column);
        dfs(grid,row,column-1);
        dfs(grid,row+1,column);
        dfs(grid,row,column+1);
    }
}
