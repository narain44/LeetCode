package educative.twopointers;

import java.util.Arrays;

public class SquareSortedArray03 {
    public static void main(String [] args){
        System.out.println("Sorted Squares of [-2, -1, 0, 2, 3] is "+ Arrays.toString(makeSquares(new int[]{-2, -1, 0, 2, 3})));
    }

    public static int[] makeSquares(int[] arr) {
        int [] squares=new int[arr.length];
        int squaresIndex=arr.length-1;
        int left=0,right= arr.length-1;
        while(left<=right){
            int leftSQRT=arr[left]*arr[left];
            int rightSQRT=arr[right]*arr[right];
            if(leftSQRT>rightSQRT){
                squares[squaresIndex]=leftSQRT;
                left++;
            }else{
                squares[squaresIndex]=rightSQRT;
                right--;
            }
            squaresIndex--;
        }
        return squares;
    }
}
