package jingda.algo.sort;

import java.util.Arrays;

/**
 * 属于排序和分而治之
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
