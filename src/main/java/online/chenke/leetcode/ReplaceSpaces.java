package online.chenke.leetcode;

import java.util.Arrays;

/**
 * 面试题 01.03
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
 * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 */
public class ReplaceSpaces {
    public static void main(String[] args) {
        String s = replaceSpaces2("               ", 5);
        s = replaceSpaces2("ds sdfs afs sdfa dfssf asdf             ", 27);
//        s = replaceSpaces2("Mr John Smith    ", 13  );
        System.out.println(s);
    }

    public static String replaceSpaces(String S, int length){
        char[] chars = S.toCharArray();

        int i=0;
        int spaceI = 0;

        while (i < length){
            if(chars[i]==' '){
                spaceI++;
            }

            i++;
        }

        char[] newChars = new char[length+spaceI*2];

        int newI = 0;
        i=0;
        while (i < length){
            if(chars[i]==' '){
                newChars[newI] = '%';
                newChars[newI+1] = '2';
                newChars[newI+2] = '0';

                newI = newI+3;
            }else{
                newChars[newI] = chars[i];
                newI++;
            }
            i++;
        }

        return String.copyValueOf(newChars);
    }

    public static String replaceSpaces2(String S, int length){
        char[] chars = S.toCharArray();
        int originI=length-1, newI=chars.length-1, spaceNum = 0;

        while (originI>=0) {
            if(chars[originI]==' '){
                chars[newI--] = '0';
                chars[newI--] = '2';
                chars[newI--] = '%';
                spaceNum++;
            }else{
                chars[newI--] = chars[originI];
            }

            originI--;
        }

        return String.copyValueOf(Arrays.copyOfRange(chars, newI+1, newI+1+length+spaceNum*2));
    }
}
