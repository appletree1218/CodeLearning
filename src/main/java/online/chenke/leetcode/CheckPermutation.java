package online.chenke.leetcode;

import java.util.Arrays;

/**
 * 面试题 01.02
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 */
public class CheckPermutation {
    public static void main(String[] args) {
        boolean b = checkPermutation("abcc","abcb");
        System.out.println(b);
    }

    public static boolean checkPermutation(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return String.copyValueOf(chars1).equals(String.copyValueOf(chars2));
    }
}
