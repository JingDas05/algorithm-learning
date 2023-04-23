package jingda.algo.sort;

import java.util.Arrays;

/**
 * 属于排序和分而治之
 *
 * 快速排序采用的是一种分治策略，即通过选定一个元素作为枢轴，将待排序序列分割成两个子序列，
 * 其中一个子序列中的所有元素都小于枢轴，另一个子序列中的所有元素都大于枢轴。然后对这两个子序列递归地进行排序
 *
 * 平均情况下，快速排序的时间复杂度约为 O(nlogn)，最坏情况下的时间复杂度为O(n^2)
 * 快速排序算法的空间复杂度为 O(logn)，主要是由于递归调用造成的栈空间的开销。
 * 在最坏情况下，即递归树的深度为 n-1 时，快速排序的空间复杂度达到最大值，为 O(n)。
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] arr = new int[] {5, 2, 8, 3, 9, 4};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr, 0, arr.length -1);
        System.out.println(Arrays.toString(arr));
    }


    public void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(arr, left, right);
        sort(arr, left, pivotIndex - 1);
        sort(arr, pivotIndex + 1, right);
    }


    private int partition(int[] arr, int left, int right) {
        //取最右面的值为枢轴（pivot）
        int pivot = arr[right];
        int i = left;
        // 从左向右遍历，如果比pivot小就放最左面i的位置，之后i++
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                // 比pivot大的值放在数组的最左面，只是保证比pivot小的都在左面，比pivot大的都在右面就好
                // 不会保证pivot左面和右面的各自有序
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }


    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
