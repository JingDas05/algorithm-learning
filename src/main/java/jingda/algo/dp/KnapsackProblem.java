package jingda.algo.dp;

/**
 * 在O(nW)的时间复杂度内解决背包问题，其中n为物品的数量，W为背包的容量
 *
 */
public class KnapsackProblem {
    public static int knapsack(int[] weights, int[] values, int W) {
        int n = weights.length;

        // 使用一个二维数组dp来保存中间结果。dp[i][w]表示当容量为w时，前i个物品能够取得的最大价值
        // 多初始化一个长度，为了第一个物体初始化，不会数组越界
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                // 1. 不放此物品，并且（当前重量-当前物品重量）下    的价值 + 当前物品价值。
                // 2. 不放此物品当前重量w最大价值。
                // 比较谁的价值大，就在当前物品和重量下赋对应的值。
                if (weights[i - 1] <= w) {
                    // 其中weights[i-1]和values[i-1]分别表示第i个物品的重量和价值。
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W];
    }


    /**                    weight
     *              0  1  2  3  4  5  6  7  8
     *           0  0  0  0  0  0  0  0  0  0
     *           1  0  3  3  3  3  3  3  3  3
     *           2  0  3  4  4  7  7  7  7  7
     *    goods  3  0  0  3  4  5  7  8  9  9
     *           4  0  0  3  4  5  7  8  9  10
     *
     */
    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int W = 8;
        int result = knapsack(weights, values, W);
        // the result is 10
        System.out.println("Knapsack maximum value: " + result);
    }
}


