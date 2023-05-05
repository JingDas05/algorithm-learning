package jingda.algo.dp;

import java.util.Arrays;

/**
 * 求最长递增序列，不一定是连续的
 */
public class LongestIncreaseSubSequence {

    public static void main(String[] args) {
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        int[] nums4 = {4, 10, 4, 3, 8, 9};
        int[] nums5 = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        LongestIncreaseSubSequence increaseSubSequence = new LongestIncreaseSubSequence();
        // 4
        System.out.println(increaseSubSequence.longestIncreaseSequence(nums1));
        /*
        *    1   1  1  1  1  1
        *    {0, 1, 0, 3, 2, 3}
        *
        *    i = 1, j = 0
        *    1   2  1  1  1  1
        *    {0, 1, 0, 3, 2, 3}
        *
        *    i = 2, j = 0,1
        *    1   2  1  1  1  1
        *    {0, 1, 0, 3, 2, 3}
        *
        *    i = 3, j = 0,1,2
        *    1   2  1  2+1  1  1
        *    {0, 1, 0, 3,   2, 3}
        *
        *    i = 4, j = 0,1,2,3
        *    1   2  1  2+1  2+1  1
        *    {0, 1, 0, 3,   2,   3}
        *
         *   i = 5, j = 0,1,2,3,4
         *   1   2  1  2+1  2+1  2+1+1=4
         *   {0, 1, 0, 3,   2,   3}
        */
        System.out.println(increaseSubSequence.longestIncreaseSequence(nums2));
        // 1
        System.out.println(increaseSubSequence.longestIncreaseSequence(nums3));
        // 3
        System.out.println(increaseSubSequence.longestIncreaseSequence(nums4));
        // 5
        System.out.println(increaseSubSequence.longestIncreaseSequence(nums5));
    }

    /**
     * 遍历顺序是正遍历
     *                j
     *      1    1    1    1    1
     *      1 -> 1    1    1    1
     * i    1 -> 1 -> 1    1    1
     *      1 -> 1 -> 1 -> 1    1
     *      1 -> 1 -> 1 -> 1 -> 1
     *
     *
     */
    public int longestIncreaseSequence(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 1;
        }

        int length = nums.length;
        // 正常应该是二维数组，每一行的最右面的值就是最大值，所以dp是一维数组就可以了
        int[] dp = new int[length];
        Arrays.fill(dp, 1);

        int maxLength = 1;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 每一行最右面的值是最大值
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
