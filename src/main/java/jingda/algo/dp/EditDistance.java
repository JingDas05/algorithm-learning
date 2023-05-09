package jingda.algo.dp;

/**
 * 两个字符串，通过【插入】【删除】和【更新】，最小编辑次数，使两个字符串一样
 */
public class EditDistance {

    /**
     * dp[i][j] 表示字符串a的前i个字符和 字符串b的前j个字符的最小编辑距离
     * <p>
     * dp[i][0] 表示字符串b是空字符串，字符串a和b的最小编辑距离
     * dp[0][j] 表示字符串a是空字符串，字符串a和b的最小编辑距离
     */
    public int minEditDistance(String a, String b) {

        int aLength = a.length();
        int bLength = b.length();

        int[][] dp = new int[aLength + 1][bLength + 1];

        // 初始化边界值
        for (int i = 0; i <= aLength; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= bLength; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= aLength; i++) {
            for (int j = 1; j <= bLength; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[aLength][bLength];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "rse";

        EditDistance editDistance = new EditDistance();
        int distance = editDistance.minEditDistance(word1, word2);
        // 2
        System.out.println("用例1最小编辑距离为：" + distance);


        String word3 = "intention";
        String word4 = "execution";
        int distance2 = editDistance.minEditDistance(word3, word4);
        // 5
        System.out.println("用例2最小编辑距离为：" + distance2);
    }
}
