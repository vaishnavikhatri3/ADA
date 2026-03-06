class KnapsackDP {

    static int knapsack(int W, int val[], int wt[]) {

        int n = wt.length;

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {

                if (i == 0 || j == 0)
                    dp[i][j] = 0;

                else {

                    int pick = 0;

                    if (wt[i - 1] <= j)
                        pick = val[i - 1] + dp[i - 1][j - wt[i - 1]];

                    int notPick = dp[i - 1][j];

                    dp[i][j] = Math.max(pick, notPick);
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String args[]) {

        int val[] = {1, 2, 5, 6};
        int wt[] = {2, 3, 4, 5};
        int W = 8;

        System.out.println("Maximum Value = " + knapsack(W, val, wt));
    }
}