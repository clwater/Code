import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3,4,5,6,7,8,9,10},
                {11,12,13,14,15,16,17,18,19,20}
        };
        List<Integer> result = new SpiralMatrix_Solution().spiralOrder(matrix);
        for (Integer integer : result) {
            System.out.print(" " + integer);
        }
    }
}


class SpiralMatrix_Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int maxHeight = matrix.length;
        int maxWidth = matrix[0].length;

        int index = 0;
        int min = Math.min(maxHeight, maxWidth);

        do {
            result.addAll(getRing(matrix, index));
            index++;
        }
        while (index <= min / 2);

        return result;

    }

    public List<Integer> getRing(int[][] matrix, int deep) {
        int maxHeight = matrix.length;
        int maxWidth = matrix[0].length;

        List<Integer> result = new ArrayList<>();


        if ((maxHeight % 2 == 1) && (deep == maxHeight / 2)) {
            for (int i = 0; i < maxWidth - 2 * deep ; i++) {
                result.add(matrix[deep][i + deep]);
            }
        } else if ((maxWidth % 2 == 1) && (deep == maxWidth / 2)) {
            for (int i = 0; i < maxHeight - 2 * deep ; i++) {
                result.add(matrix[deep + i][maxWidth - deep - 1]);
            }
        } else {

            for (int i = 0; i < maxWidth - 2 * deep - 1; i++) {
                result.add(matrix[deep][i + deep]);
            }

            for (int i = 0; i < maxHeight - 2 * deep - 1; i++) {
                result.add(matrix[deep + i][maxWidth - deep - 1]);
            }

            for (int i = maxWidth - 2 * deep - 1; i > 0; i--) {
                result.add(matrix[maxHeight - deep - 1][i + deep]);
            }

            for (int i = 0; i < maxHeight - 2 * deep - 1; i++) {
                result.add(matrix[maxHeight - deep - i - 1][deep]);
            }
        }


        return result;
    }

}