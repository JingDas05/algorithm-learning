package jingda.algo.sort;

import java.util.Arrays;

/**
 * 归并排序，升序列
 *
 * 归并排序也采用分治策略，它是将待排序序列分成两个长度相等的子序列，直至不能进行切分
 * 对这两个子序列归并合并成一个有序序列，归并的过程中，要进行排序（大小比较）
 *
 * 归并排序的时间复杂度始终为O(nlogn),归并排序的空间复杂度为O(n)（需要一个临时数组）
 * 快速排序通常比归并排序更快，但在处理大规模数据时，归并排序通常更可靠。
 */
public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSortObj = new MergeSort();

        /**
         *
         *          6 3 2 9        1 5 7
         *      6 3      2 9      15    7
         *     6   3    2   9    1  5   7
         *
         *     3   6    2   9    1  5   7
         *       36      29       15    7
         *         2369            157
         *              1235679
         */
        int[] source = new int[]{6, 3, 2, 9, 1, 5, 7};
        mergeSortObj.mergeSort(source, 0, 6);
        // MergeSort dest =[1, 2, 3, 5, 6, 7, 9]
        System.out.println("MergeSort dest =" + Arrays.toString(source));
    }

    public void mergeSort(int[] array, int left, int right) {

        if (left < right) {
            int middle = (left + right) / 2;
            // 先排序 左半部分
            mergeSort(array, left, middle);
            // 再排序 右半部分
            mergeSort(array, middle + 1, right);
            // 将左右两部分 归并，并且按照大小排序
            merge(array, left, middle, right);
        }
    }

    public void merge(int[] array, int left, int middle, int right) {

        int tmpLength = right - left + 1;
        int[] tmp = new int[tmpLength];

        int i = left;
        int j = middle + 1;
        int k = 0;

        // 两个有序数组 合并
        while (i <= middle && j <= right) {
            if (array[i] < array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
            }
        }
        while (i <= middle) {
            tmp[k++] = array[i++];
        }
        while (j <= right) {

            tmp[k++] = array[j++];
        }

        // 将临时数组 赋值给array
        for (int l = 0; l < tmpLength; l++) {
            array[left + l] = tmp[l];
        }
    }
}
