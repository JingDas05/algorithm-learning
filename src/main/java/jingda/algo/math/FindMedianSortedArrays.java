package jingda.algo.math;

/**
 * 有两个有序数组
 * 计算两个数组的中位数
 * 如果数组个数n为奇数，中位数就是 n/2
 * 如果数组个数n为偶数，中位数就是 （nums[n/2 - 1] + nums[n/2]）/ 2.0(注意这里是 2.0)
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        FindMedianSortedArrays findMedianSortedArrays =
                new FindMedianSortedArrays();

        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2, 4};

        // 应该是 2.5
        System.out.println("median1 = " + findMedianSortedArrays.calcMedianNum(nums1, nums2));

        int[] nums3 = new int[]{3};
        int[] nums4 = new int[]{2, 9};

        // 应该是 3
        System.out.println("median2 = " + findMedianSortedArrays.calcMedianNum(nums3, nums4));
    }

    public double calcMedianNum(int[] nums1, int[] nums2) {

        int nLength1 = nums1.length;
        int nLength2 = nums2.length;
        int totalLength = nLength1 + nLength2;
        int[] num = new int[totalLength];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < nLength1 && j< nLength2) {
            if (nums1[i] < nums2[j]) {
                num[k++] = nums1[i++];
            }else {
                num[k++] = nums2[j++];
            }
        }

        while (i < nLength1) {
            num[k++] = nums1[i++];
        }

        while (j < nLength2) {
            num[k++] = nums2[j++];
        }


        if (totalLength % 2 ==0) {
            // 如果是偶数就返回 中间两数相加/2.0
            return (num[totalLength/2 -1] + num[totalLength/2])/2.0;
        }else {
            // 如果是奇数，就返回中间数
            return num[totalLength/2];
        }
    }
}
