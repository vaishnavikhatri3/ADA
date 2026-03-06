import java.util.Arrays;

class KnapsackMemo {

    static int kSackRec(int W, int wt[], int val[], int index, int memo[][]) {

        // Base case
        if (index < 0)
            return 0;

        // If value already calculated
        if (memo[index][W] != -1)
            return memo[index][W];

        // If item weight is greater than capacity
        if (wt[index] > W) {
            memo[index][W] = kSackRec(W, wt, val, index - 1, memo);
        } 
        else {

            int include = val[index] + kSackRec(W - wt[index], wt, val, index - 1, memo);

            int exclude = kSackRec(W, wt, val, index - 1, memo);

            memo[index][W] = Math.max(include, exclude);
        }

        return memo[index][W];
    }

    static int kSack(int W, int wt[], int val[]) {

        int n = wt.length;

        int memo[][] = new int[n][W + 1];

        for (int[] row : memo)
            Arrays.fill(row, -1);

        return kSackRec(W, wt, val, n - 1, memo);
    }

    public static void main(String args[]) {

        int val[] = {60, 100, 120};   // profits
        int wt[] = {10, 20, 30};      // weights
        int W = 50;                   // capacity

        System.out.println("Maximum Profit = " + kSack(W, wt, val));
    }
}