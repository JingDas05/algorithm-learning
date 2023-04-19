package jingda.algo.dp;

/**
 *
 */
public class LongestPalindrome {


    public static void main(String[] args) {

        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String s1 = "babad";
        String s2 = "cbbd";
        String s3 = "a";

        System.out.println("longestPalindrome s1 = " + longestPalindrome.longestPalindrome(s1));
        System.out.println("longestPalindrome s2 = " + longestPalindrome.longestPalindrome(s2));
        System.out.println("longestPalindrome s3 = " + longestPalindrome.longestPalindrome(s3));
    }

    public String longestPalindrome(String source) {
        if (source == null || "".equals(source)) {
            return null;
        }

        int length = source.length();
        boolean[][] dp = new boolean[length][length];

        /*
         *  i i+1           j-1 j
         *  因为比较   dp[i][j] 和 dp[i+1][j-1]所以需要反向遍历
         *          dp[i][j-1]        dp[i][j]
         *          dp[i+1][j-1]      dp[i+1][j]
         *
         *  反向遍历就是
         *
         *        j
         * -------------->
         * *------------->
         * * *----------->
     i   * * * *--------->
         * * * * *------->
         * * * * * *----->
         * * * * * * *--->
         * * * * * * * *->
         * */
        int start = 0; int end = 0;
        for (int i = length -1; i>=0; i--) {
            for (int j = i; j < length; j++) {
                if (source.charAt(i) == source.charAt(j)) {
                    // 字符相等的情况下，并且间距小于等于2一定是回文
                    if (j-i <=2) {
                        dp[i][j] = true;
                    }else {
                        // 否则就取上一次的结果
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else {
                    dp[i][j] = false;
                }
                if (dp[i][j] && j - i > end - start) {
                    start = i;
                    end = j;
                }
            }
        }
        return source.substring(start, end + 1);
    }
}
