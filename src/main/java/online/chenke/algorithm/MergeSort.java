package online.chenke.algorithm;

import java.util.Arrays;

/**
 * 归并排序
 *  1、先拆，拆到最小粒度（每个组中只有一个元素），从最小粒度开始merge
 *  2、两部分相当于有两个指针，两个指针哪个指向的值哪个更小，就将对应的那个值放到tmp中，然后这个指针往后走
 *  3、最后处理指针没有走完的那部分数据，直接放到tmp中, 将tmp中的数据覆盖到原数组对应的位置
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,6,8,7,2,5,4,6,9};

        split(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void split(int[] arr, int L, int R){
        int mid = L+((R-L)>>1);

        if(L == R){
            return ;
        }

        split(arr, L, mid);
        split(arr, mid+1, R);
        merge(arr, L, R, mid);
    }

    public static void merge(int[] arr, int L, int R, int mid){
        int indexL = L;
        int indexR = mid+1;
        int i = 0;

        int[] temp = new int[R-L+1];

        while (indexL<=mid && indexR<=R){
            temp[i++] = arr[indexL]<=arr[indexR]?arr[indexL++]:arr[indexR++];
        }

        while (indexL<=mid){
            temp[i++] = arr[indexL++];
        }

        while (indexR<=R){
            temp[i++] = arr[indexR++];
        }

        for (i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
    }
}
