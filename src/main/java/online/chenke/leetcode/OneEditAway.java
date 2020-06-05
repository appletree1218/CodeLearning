package online.chenke.leetcode;

/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑
 */
public class OneEditAway {
    public static void main(String[] args) {
        boolean b = oneEditAway("teacher", "treacher");
        System.out.println(b);
    }

    public static boolean oneEditAway(String first, String second) {
        char[] chars1 = first.toCharArray();
        char[] chars2 = second.toCharArray();

        int len1 = chars1.length;
        int len2 = chars2.length;

        int p1=0, p2=0;
        int diff=0;

        if(len1==len2){
            if(diff>1){
                return false;
            }
            while (p1<len1 && p2<len2){
                if(chars1[p1]!=chars2[p2]){
                    diff++;
                }

                p1++;
                p2++;
            }

            return diff<=1;
        }

        if(Math.abs(len1-len2)>1){
            return false;
        }

        diff=0;
        while(p1<len1&&p2<len2){
            if(diff>1){
                return false;
            }

            if(chars1[p1] != chars2[p2]){
                diff++;

                if(len1>len2){
                    p1++;
                }else{
                    p2++;
                }

                continue;
            }

            p2++;
            p1++;
        }

        return diff<=1;
    }
}
