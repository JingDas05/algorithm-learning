package jingda.algo.greedy;

/**
 *
 */
public class ActivitySelection {

    public int maxActivities(int[] start, int[] end) {
        // 至少选择一个活动
        int count = 1;
        // 初始活动是结束最早的活动
        int lastEnd = end[0];

        int length = start.length;
        // 只要下一个活动的开始时间晚于已有活动的结束时间，那么就选择
        for (int i = 1; i < length; i++) {
            if (start[i] >= lastEnd) {
                lastEnd = end[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] start = new int[] {1, 3, 0, 5, 8, 5};
        int[] end = new int[] {2, 4, 6, 7, 9, 9};
        ActivitySelection activitySelection = new ActivitySelection();
        // 应该是4
        System.out.println(activitySelection.maxActivities(start, end));
    }
}
