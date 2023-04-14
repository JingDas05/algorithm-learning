package jingda.algo.math;

import java.util.Arrays;
import java.util.HashMap;

import java.util.Map;

/**
 * 可以通过双层for循环来实现的，在第二层循环寻找 sum = target的值
 * 空间换时间，可以使用map存储数组数据和位置的索引，可以快速找到和等于
 * sum的另外的值的位置
 */
public class TwoNumSumTest {

    public static void main(String[] args) {
        int[] source = new int[]{1, 3, 5, 7, 6, 2, 5};
        int sum = 10;
        TwoNumSumTest twoNumSumTest = new TwoNumSumTest();
        int[] index = twoNumSumTest.calcTwoNumSum(source, sum);
        System.out.println("index" + Arrays.toString(index));
    }

    public int[] calcTwoNumSum(int[] source, int target) {
        // 对数组构建索引, key是数值， value是数所在位置
        Map<Integer, Integer> valueAndIndexMap = new HashMap<>();

        int length = source.length;

        for (int i = 0; i < length; i++) {
            int residueValue = target - source[i];
            if (valueAndIndexMap.containsKey(residueValue)) {
                return new int[]{i, valueAndIndexMap.get(residueValue)};
            }
            valueAndIndexMap.put(source[i], i);
        }
        return new int[]{};
    }
}
