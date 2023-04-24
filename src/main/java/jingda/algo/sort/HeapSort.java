package jingda.algo.sort;

import java.util.Arrays;

/**
 * 堆排序算法的时间复杂度为O(nlogn)，空间复杂度为O(1)
 * 它是一种比较高效的排序算法，尤其适合处理大规模数据。
 */
public class HeapSort {

    public static void main(String[] args) {

        int[] array = new int[] {3, 2, 1, 7, 6, 5};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(array);

        System.out.println("HeapSort sorted array" + Arrays.toString(array));
    }

    public void heapSort(int[] array) {

        int arrayLength = array.length;

        // 首先构建大顶堆,因为左右子节点在 2i 的位置，
        // 所以只需要在数组的中间开始，依次减少i，来构建大顶堆
        for (int i = arrayLength / 2 - 1; i >= 0; i--) {
            adjust(array, arrayLength, i);
        }

        // 首先将堆顶array[0]位置的数（堆中最大的数）和堆最后数互换
        // 对剩下的堆以 0（此时已经被替换了） 的位置为起点，总数-1，再进行堆排序
        // 重复之前操作，最终会形成一个升序数组
        for (int j = arrayLength - 1; j >= 0; j--) {

            int tmp = array[0];
            array[0] = array[j];
            array[j] = tmp;

            // 需要注意，此时数组最后一位不参与排序，所以总数为 j = arrayLength - 1
            adjust(array, j, 0);
        }
    }

    /**
     * 数组 array 中的 start 位置的数作为起点，进行调整
     * 调成大顶堆或者小顶堆，这里是小顶堆
     */
    public void adjust(int[] array, int totalSize, int start) {

        int leftChildIndex = 2 * start + 1;
        int rightChildIndex = 2 * start + 2;

        // 最大值位置初始化起始
        int maxIndex = start;

        // 如果左子节点数更大，就使用左子节点索引位置
        if (leftChildIndex < totalSize &&
                array[leftChildIndex] > array[maxIndex]) {
            maxIndex = leftChildIndex;
        }

        // 如果右子节点数更大，就使用左子节点索引位置
        if (rightChildIndex < totalSize &&
                array[rightChildIndex] > array[maxIndex]) {
            maxIndex = rightChildIndex;
        }

        // 如果初始 start 不是最大位置，就进行互换
        if (maxIndex != start) {
            int tmp = array[start];
            array[start] = array[maxIndex];
            // 此时 maxIndex 位置的数据发生变化了，替换成了 start 位置的数据
            array[maxIndex] = tmp;
            // 继续递归处理 maxIndex 位置开始的数据
            adjust(array, totalSize, maxIndex);
        }
    }
}
