package online.chenke.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = new int[]{4,3,5,3,1,1,2,4,8,7,5};

        for (int i = 1;i < array.length;i++){
            int j = i-1;
            int temp = array[i];

            for(; j>=0;j--){
                if(temp<array[j]){
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }

            array[j+1] = temp;
        }

        System.out.println(Arrays.toString(array));
    }
}
