package online.chenke.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序, 升序排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 4, 5, 2, 1, 2, 3};

        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    array[j] = array[j] ^ array[j + 1];
                    array[j + 1] = array[j] ^ array[j + 1];
                    array[j] = array[j] ^ array[j + 1];
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
