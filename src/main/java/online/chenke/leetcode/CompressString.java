package online.chenke.leetcode;

/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。
 * 若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 */
public class CompressString {
    public static void main(String[] args) {
        String result = compressString("aabcccccaaa");
        System.out.println(result);
    }

    public static String compressString(String S) {
        if(S.length()<2){
            return S;
        }

        char[] chars = S.toCharArray();
        int len = chars.length;
        StringBuilder newChars = new StringBuilder();

        char temp = chars[0];
        int count=1,k=0;

        for (int i = 1; i <= len; i++) {

            if(k>=len-1){
                return S;
            }

            if(i==len || temp != chars[i]){
                newChars.append(temp);
                newChars.append(count);

                if(i!=len){
                    temp = chars[i];
                    count=1;
                }
            }else{
                count++;
            }
        }

        if(newChars.length()<len){
            return newChars.toString();
        }
        return S;
    }
}
