package jingda.algo.math;

/**
 * 求取一段数组中连续的最大子序列和
 * 方法1： 前缀和，preSum[i]代表前i个数的总和，索引位置i至j的和
 * 和等于 preSum[j] - preSum[i]，最大子序列和就是让preSum[j]尽可能大，preSum[i]尽可能小
 */
public class MaxSubSumArray {


    public static void main(String[] args) {

        MaxSubSumArray maxSubSumArray = new MaxSubSumArray();

        // 13
        int[] nums1 = new int[]{1, -1, 2, 5, -8, 9, 4};
        System.out.println("max calcMaxSum1 = " + maxSubSumArray.calcMaxSubSum(nums1));

        //14
        int[] nums2 = new int[]{1, -1, 2, 5, -6, 9, 4};
        System.out.println("max calcMaxSum2 = " + maxSubSumArray.calcMaxSubSum(nums2));
    }

    public int calcMaxSubSum(int[] source) {

        int size = source.length;
        int[] preSum = new int[size + 1];

        int minPreSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 1; i <= size; i++) {
            preSum[i] = preSum[i - 1] + source[i - 1];
            minPreSum = Math.min(minPreSum, preSum[i]);
            maxSum = Math.max(maxSum, preSum[i] - minPreSum);
        }
        return maxSum;
    }
}
