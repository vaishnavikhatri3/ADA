import java.util.Arrays;

class FibonacciMemo {

    static int fibRec(int n, int[] memo) {

        if (n <= 1)
            return n;

        if (memo[n] != -1)
            return memo[n];

        memo[n] = fibRec(n - 1, memo) + fibRec(n - 2, memo);

        return memo[n];
    }

    static int fib(int n) {

        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return fibRec(n, memo);
    }

    public static void main(String[] args) {

        int n = 5;
        System.out.println("Fibonacci number: " + fib(n));
    }
}
