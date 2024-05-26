package jingda.algo.window;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续
 * 子数组
 * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
class Solution {
    public static int minSubArrayLen(int target, int[] nums) {
        int beginIndex = 0;
        int endIndex = beginIndex;
        int minNum = 0;
        int currentSum = nums[beginIndex];

        while (endIndex <= nums.length) {
            if (minNum == 1) {
                return minNum;
            }
            if (currentSum >= target) {
                minNum = minNum == 0 ? endIndex - beginIndex + 1 : Math.min(minNum, endIndex - beginIndex + 1);
                while (beginIndex < endIndex) {
                    currentSum -= nums[beginIndex++];
                    if (currentSum < target) {
                        break;
                    } else {
                        minNum = minNum == 0 ? endIndex - beginIndex + 1 : Math.min(minNum, endIndex - beginIndex + 1);
                    }
                }
            } else {
                if (++endIndex < nums.length) {
                    currentSum += nums[endIndex];
                } else {
                    ++endIndex;
                }
            }
        }
        return minNum;
    }

    public static void main(String[] args) {
//        int target = 7;
//        int[] nums = new int[] {2, 3, 1, 2, 4, 3};
//        int result = minSubArrayLen(target, nums);
//        System.out.println(result);

        int target = 4;
        int[] nums = new int[] {1, 4, 4};
        int result = minSubArrayLen(target, nums);
        System.out.println(result);
    }
}