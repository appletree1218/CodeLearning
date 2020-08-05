package online.chenke.algorithm;

import java.util.Arrays;

/**
 * 选择排序 从0开始遍历，拿出一个元素和后面的进行比较， 如果不是最小，记录下最小元素的索引，继续比较，走完一遍循环后将最小的那个元素和最外层的那个元素进行交换
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 2, 1, 3, 4, 5, 6, 9, 7};
        int len = array.length;
        int minIndex, temp;

        for (int i = 0; i < len; i++) {
            minIndex = i;

            for (int j = i + 1; j < len; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
