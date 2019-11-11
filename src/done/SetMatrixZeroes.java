/*
 *给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * 输入:
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 *
 * 输出:
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetMatrixZeroes {
    public static void main(String[] args) {
//        int[][] matrix = new int[][]{
//                {0, 1, 2, 0},
//                {3, 4, 5, 2},
//                {1, 3, 1, 5}
//        };

        int[][] matrix = new int[][]{
                {0, 1},
        };
        new SetMatrixZeroes_Solution().setZeroes(matrix);
    }
}

class SetMatrixZeroes_Solution {

    public void setZeroes(int[][] matrix) {
        boolean firstCol = false, firstRow = false;

        for (int i = 0 ; i < matrix.length; i++){
            if (matrix[i][0] == 0){
                firstCol = true;
                break;
            }
        }

        for (int i = 0 ; i < matrix[0].length; i++){
            if (matrix[0][i] == 0){
                firstRow = true;
                break;
            }
        }

        for (int i = 0 ; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        if ( matrix.length > 1 && matrix[0].length > 1){
            for (int i = 1 ; i < matrix.length; i++){
                for (int j = 1; j < matrix[i].length; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if (firstCol){
            for (int i = 0 ; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }

        if (firstRow){
            for (int i = 0 ; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }



        for (int i = 0 ; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }

//    public void setZeroes(int[][] matrix) {
//        Set<Integer> row = new HashSet<>();
//        Set<Integer> col = new HashSet<>();
//
//
//        for (int i = 0 ; i < matrix.length; i++){
//            for (int j = 0; j < matrix[i].length; j++){
//                if (matrix[i][j] == 0){
//                    row.add(i);
//                    col.add(j);
//                }
//            }
//        }
//
//        for (int i = 0 ; i < matrix.length; i++){
//            for (int j = 0; j < matrix[i].length; j++){
//                if (row.contains(i) || col.contains(j)){
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//
//        for (int i = 0 ; i < matrix.length; i++){
//            for (int j = 0; j < matrix[i].length; j++){
//                System.out.print(matrix[i][j] + ", ");
//            }
//            System.out.println();
//        }
//    }


}