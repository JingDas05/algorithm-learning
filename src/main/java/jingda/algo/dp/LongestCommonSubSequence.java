package jingda.algo.dp;

/**
 * 求两个字符串，最长公共子序列
 * 最长共同子序列不一定要连续在一起
 * 比如 ABCDGH 和 AEDFHR 的最长公共子序列是 A D H
 */
public class LongestCommonSubSequence {

    public int lcs(String a, String b) {

        int aLength = a.length();
        int bLength = b.length();
        // lscDp[i][j]表示 a字符串的第i个字符 和 b字符串的第j个字符的最长子序列长度大小
        int[][] lcsDp = new int[aLength + 1][bLength + 1];
        StringBuilder stringBuilder = new StringBuilder();

        // dp的存储长度要比实际维度（字符串长度）+1
        // 字符串在dp中的存储是从下标1开始的，注意这个地方是 <=
        // i 和 j分别代表字符串对应i和j位置上的字符串，读取字符时位置是 i-1 或者 j-1
        for (int i = 1; i <= aLength; i++) {
            for (int j = 1; j <= bLength; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    lcsDp[i][j] = lcsDp[i - 1][j - 1] + 1;
                    stringBuilder.append(a.charAt(i - 1));
                } else {
                    lcsDp[i][j] = Math.max(lcsDp[i - 1][j], lcsDp[i][j - 1]);
                }
            }
        }
        System.out.println("lcs string= " + stringBuilder.toString());
        return lcsDp[aLength][bLength];
    }

    public static void main(String[] args) {

        String a = "ABCDGH";
        String b = "AEDFHR";

        /*
         *        A B C D G H
         *      0 1 2 3 4 5 6
         *    0 0 0 0 0 0 0 0
         *  A 1 0 1 1 1 1 1 1
         *  E 2 0 1 1 1 1 1 1
         *  D 3 0 1 1 1 2 2 2
         *  F 4 0 2 2 2 2 2 2
         *  H 5 0 2 2 2 2 2 3
         *  R 6 0 3 3 3 3 3 3
         */

        LongestCommonSubSequence longestCommonSubSequence = new LongestCommonSubSequence();
        int lcs = longestCommonSubSequence.lcs(a, b);
        System.out.println("lcs = " + lcs);
    }
}
