package jingda.algo.search.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 寻找字符串中无重复的最大子串及长度
 */
public class MaxUniqueSubSequence {

    public static void main(String[] args) {
        MaxUniqueSubSequence maxUniqueSubSequence = new MaxUniqueSubSequence();
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        System.out.println("s1 max unique subsequence = " + maxUniqueSubSequence.findMaxUniqueSub(s1));
        System.out.println("s2 max unique subsequence = " + maxUniqueSubSequence.findMaxUniqueSub(s2));
        System.out.println("s3 max unique subsequence = " + maxUniqueSubSequence.findMaxUniqueSub(s3));
    }

    public String findMaxUniqueSub(String source) {

        int length = source.length();
        int maxUniqueSubLength = 0;
        String maxUniqueSubStr = "";
        Map<Character, Integer> charIndex = new HashMap<>();
        for (int left = 0, right = 0; right < length; right++) {
            char eachChar = source.charAt(right);
            // 如果发现字符串出现重复的字符串
            if (charIndex.containsKey(eachChar)) {
                // 就把左指针移动到重复字符的下一个位置
                left = Math.max(charIndex.get(eachChar) + 1, right);
            }
            charIndex.put(eachChar, right);

            int oldMax = maxUniqueSubLength;
            maxUniqueSubLength = Math.max(maxUniqueSubLength, right - left + 1);
            if (maxUniqueSubLength != oldMax) {
                maxUniqueSubStr = source.substring(left, left + maxUniqueSubLength);
            }
        }
        return maxUniqueSubStr;
    }
}
