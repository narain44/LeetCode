package TreasureIsland;

public class SolutionDFS {

    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r  < 0 || c < 0 || r  >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int nr=grid.length;
        int nc=grid[0].length;
        int numOfIslands=0;
        for(int r=0;r<nr;r++){
            for(int c=0;c<nc;c++){
                if(grid[r][c] == '1'){
                    numOfIslands++;
                    dfs(grid,r,c);
                   // grid[r][c] = '0';
                }

            }
        }
        return numOfIslands;
    }

    public static void main(String[] args) {
        char[][] terrain = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        SolutionDFS solutionDFS = new SolutionDFS();
        int numberOfIslands = solutionDFS.numIslands(terrain);
        System.out.println("Number Of islands : " + numberOfIslands);

        char[][] terrain2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        numberOfIslands = solutionDFS.numIslands(terrain2);
        System.out.println("Number Of islands in Terrain 2: " + numberOfIslands);
    }

}
