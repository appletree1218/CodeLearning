package online.chenke.leetcode;

public class CanPermutePalindrome {
    public static void main(String[] args) {
        boolean result = canPermutePalindrome("aa");
        System.out.println(result);
    }

    public static boolean canPermutePalindrome(String s) {
        char[] chars = s.toCharArray();
        int[] chars1 = new int[128];
        int odd=0;

        for (int i = 0; i < chars.length; i++) {
            chars1[chars[i]]++;
        }

        for (int i = 0; i < chars1.length; i++) {
            if(chars1[i]%2!=0){
                odd++;
            }
        }

        if(chars.length%2!=0){
            return odd==1;
        }

        return odd==0;
    }
}
