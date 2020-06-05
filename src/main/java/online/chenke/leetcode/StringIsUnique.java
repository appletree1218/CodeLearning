package online.chenke.leetcode;

/**
 * 面试题 01.01. 判定字符是否唯一
 */
public class StringIsUnique {
    public static void main(String[] args) {
        boolean leecaode = isUnique("abccd");
        System.out.println(leecaode);
    }

    public static boolean isUnique(String astr) {
        char[] chars = astr.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int index = astr.lastIndexOf(chars[i]);
            if(index>-1 && index!=i){
                return false;
            }
        }

        return true;
    }
}
