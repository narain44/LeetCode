package ProblemRotateImage;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution instance = new Solution();
        int[][] matrix=new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(Arrays.deepToString(matrix));
        instance.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void rotateTranspose(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }


    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i=0;i<(n+(n%2)/2);i++){
            for(int j=0;j<n/2;j++){
                int l=n-1-i;
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[l][i];
                matrix[l][i]=matrix[l][l];
                matrix[l][l]=matrix[i][l];
                matrix[i][l]=tmp;
            }

        }

    }


}
