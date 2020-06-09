package online.chenke.leetcode;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 */
public class SetZeroes {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        System.out.println(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        boolean[] line = new boolean[row];
        boolean[] column = new boolean[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j]==0){
                    line[i] = true;
                    column[j] = true;
                }
            }
        }

        int[] zeroCol = new int[col];

        for (int i = 0; i < col; i++) {
            zeroCol[i] = 0;
        }

        for (int i = 0; i < line.length; i++) {
            if(line[i]){
                matrix[i] = zeroCol;
            }
        }

        for (int i = 0; i < column.length; i++) {
            if(column[i]){
                for (int j = 0; j < row; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

    }
}
