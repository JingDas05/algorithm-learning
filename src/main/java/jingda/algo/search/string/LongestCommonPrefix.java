package jingda.algo.search.string;

/**
 * 多个字符串，提取最长公共前缀
 * 将第一个字符串作为前缀，如果不能作为前缀，就把第一个字符串截断-1
 * 对其他字符串重复上述操作
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String s1 = "keys";
        String s2 = "kenqqq";
        String s3 = "ssee";

        String[] source = new String[]{s1, s2, s3};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String prefix = longestCommonPrefix.findLongestCommonPrefix(source);
        System.out.println("longestCommonPrefix = " + prefix);
    }

    public String findLongestCommonPrefix(String[] input) {

        int inputSize = input.length;
        String initPrefix = input[0];
        for (int i = 1; i < inputSize; i++) {
            while (input[i].indexOf(initPrefix) != 0) {
                initPrefix = initPrefix.substring(0, initPrefix.length() -1);
            }
        }
        return initPrefix;
    }
}
