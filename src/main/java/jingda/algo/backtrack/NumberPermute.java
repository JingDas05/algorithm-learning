package jingda.algo.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2023-08-27日 12:27:48
 * 给定一定的数组，元素不相同，求全排列
 * 比如给定 [2, 4, 5]
 * 全排列为 [2, 4, 5] [2, 5, 4] [4, 2, 5] [4, 5, 2] [5, 4, 2] [5, 2, 4]
 */
public class NumberPermute {

    public static void main(String[] args) {
        NumberPermute numberPermute = new NumberPermute();
        int[] numbers = new int[] {2, 4, 5};
        List<List<Integer>> permute = numberPermute.permute(numbers);
        permute.forEach(each -> {
            System.out.println("permute numbers is " + each.toString());
        });
    }

    List<List<Integer>> result = new ArrayList<>();

    List<List<Integer>> permute(int[] numbers) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(numbers, track);
        return result;
    }

    void backTrack(int[] numbers, LinkedList<Integer> track) {

        // 结束条件，如果 track 到树的最底层（以及没有选择了）
        if (numbers.length == track.size()) {
            result.add(new LinkedList<>(track));
            return;
        }

        // 做出选择
        for (int number : numbers) {
            if (track.contains(number)) {
                // 已经选择过了，继续做其他选择
                continue;
            }
            // 做出选择
            track.add(number);
            // 继续深入探究
            backTrack(numbers, track);
            // 取消选择（回溯）
            track.removeLast();
        }
    }
}
