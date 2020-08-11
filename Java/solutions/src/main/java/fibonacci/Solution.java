package fibonacci;

public class Solution {
    public static void main(String[] args) {
        Solution instance = new Solution();
        System.out.println("0 :" + instance.fibonacci(0));
        System.out.println("1 :" + instance.fibonacci(1));
        System.out.println("2 :" + instance.fibonacci(2));
        System.out.println("3 :" + instance.fibonacci(3));
        System.out.println("4 :" + instance.fibonacci(4));
        System.out.println("5 :" + instance.fibonacci(5));
        System.out.println("6 :" + instance.fibonacci(6));
        System.out.println("7 :" + instance.fibonacci(7));
        System.out.println("8 :" + instance.fibonacci(8));
        System.out.println("9 :" + instance.fibonacci(9));

        System.out.println("9 :" + instance.fibonacciDynamicProgramming(9));
        System.out.println("9 :" + instance.fibonacciUsingIteration(3));
    }

    private int fibonacci(int n) {
        if (n == 0 || n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    private int fibonacciDynamicProgramming(int n) {
        /* Declare an array to store Fibonacci numbers. */
        int f[] = new int[n + 2]; // 1 extra to handle case, n = 0
        int i;

        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++) {
       /* Add the previous 2 numbers in the series
         and store it */
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }


    private int fibonacciUsingIteration(int n) {
        int a = 0, b = 1, c;
        if (n == 0)
            return a;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

}
