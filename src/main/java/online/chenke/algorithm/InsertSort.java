package online.chenke.algorithm;

import java.util.Arrays;

/**
 * 插入排序
 * 选一个元素，和前面的所有元素进行比较，如果小于前面的元素，就依次向后面移动，前面没有比当前选中元素大的了就停止，然后把当前元素填到那个位置上
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 5, 3, 1, 1, 2, 4, 8, 7, 5};

        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int temp = array[i];

            for (; j >= 0; j--) {
                if (temp < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }

            array[j + 1] = temp;
        }

        System.out.println(Arrays.toString(array));
    }
}
