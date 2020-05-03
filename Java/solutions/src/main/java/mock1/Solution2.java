package mock1;

public class Solution2 {
    public static void main(String [] args){
        Solution2 instance =new Solution2();
        System.out.println("Number of  minutes to ROT "+instance.generateMatrix(3));
    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int row = 0;
        int column = 0;

        for (int i = 1; i <= n * n; i++) {
            result[row][column] = i;
            column++;
            if (column >= n) {
                column = 0;
                row++;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print("------");
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j]);
            }
        }

        return result;
    }
}
