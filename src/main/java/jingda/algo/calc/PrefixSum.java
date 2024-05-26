package jingda.algo.calc;

/**
 * 2023年08月22日 11:04:21
 * 求数组中，和为k最大的子数组， 比如
 * [   1, 3, 8, -2, -7, 10, 12]最大子数组的和应该是所有元素相加 25
 * 对应的前缀和
 * [0, 1, 4, 12, 10, 3, 13, 25]
 */
public class PrefixSum {

    public static void main(String[] args) {
        PrefixSum prefixSum = new PrefixSum();
        int[] numbers = new int[] {1, 3, 8, -2, -7, 10, 12};
        System.out.println("max sum is " + prefixSum.maxSum(numbers));
    }

    public int maxSum(int[] numbers) {

        int length = numbers.length;

        int[] prefixSum = new int[length + 1];
        prefixSum[0] = 0;

        int minPrefixSum = prefixSum[0];

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            // 计算前缀和
            prefixSum[i + 1] = prefixSum[i] + numbers[i];
            minPrefixSum = Math.min(minPrefixSum, prefixSum[i + 1]);
            maxSum = Math.max(maxSum, prefixSum[i + 1] - minPrefixSum);
        }
        return maxSum;
    }
}
