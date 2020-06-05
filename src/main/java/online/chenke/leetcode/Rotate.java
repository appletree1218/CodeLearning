package online.chenke.leetcode;

/**
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * 不占用额外内存空间能否做到？
 * 思路：
 *    1、将矩阵第1行和第n交换，第2行和第n-1行交换...
 *    2、将N的矩阵的第1行第1列进行交换，交换完剩下一个N-1的矩阵
 *    3、将N-1的矩阵的第1行第1列进行交换...重复，直到为2的矩阵第1行第1列交换结束
 */
public class Rotate {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{5, 1, 9,11},{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
        rotate(matrix);
        System.out.println(matrix);
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        int mid = n >> 1;
        int[] temp;

        for (int i = 0; i < mid; i++){
            temp = matrix[i];
            matrix[i] = matrix[n-1-i];
            matrix[n-1-i] = temp;
        }

        int tmp;
        for (int i = 1; i < n;i++){
            for(int j=i;j>0;j--){
                tmp = matrix[i][i-j];
                matrix[i][i-j] = matrix[i-j][i];
                matrix[i-j][i] = tmp;
            }
        }
    }
}
