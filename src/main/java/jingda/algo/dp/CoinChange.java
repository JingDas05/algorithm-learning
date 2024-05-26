package jingda.algo.dp;

import java.util.Arrays;

/**
 * 2023-08-25日 09:11:19
 * <p>
 * 给定k个面值的硬币，比如 c1,c2,c3,c4,ck等，每种硬币数量不限
 * 给定一个金额m,求最少用几个硬币可以凑成金额m
 */

public class CoinChange {


    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coinValues = new int[]{1, 2, 4};
        // 4
        int minNum = coinChange.choiceCoin(coinValues, 11);
        System.out.println("minNum1  = " + minNum);
        // 5
        minNum = coinChange.choiceCoin(coinValues, 17);
        System.out.println("minNum2  = " + minNum);
    }


    // 定义状态转移方程，dp(amount) = num, amount是总金额，num是需要的最少硬币数量
    // dp一维数组足够可以作为备忘录，数组中存储的是硬币的数量，数组的下标表示金额数量（状态）
    // 选择不同的硬币，会产生不同的金额（状态转移）

    // base base 初始化状态 当amount = 0 时， 需要的硬币数量也为0

    // 返回的是凑成金额 amount 最少的硬币数量
    public int choiceCoin(int[] coinValues, int amount) {
        // 需要包括 amount = 0的情况
        int[] dp = new int[amount + 1];
        // 为了比较最小，初始化dp值为 amount + 1
        int initValue = amount + 1;
        Arrays.fill(dp, initValue);

        // 初始化状态
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coinValue : coinValues) {
                if (i - coinValue < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coinValue]);
            }
        }
        return dp[amount] == initValue ? -1 : dp[amount];
    }
}
