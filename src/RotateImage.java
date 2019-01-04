/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        int[][] result = new RotateImage_Solution().rotate(matrix);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }
    }

}

class RotateImage_Solution {
    public int[][] rotate(int[][] matrix) {
        int max = matrix.length;
        for (int i = 0; i < max / 2; i++) {
            for (int j = 0; j < max - 1 - 2 * i; j++) {
                int temp;
                temp = matrix[i][i + j];
                matrix[i][i + j] = matrix[max - 1 - j - i][i];
                matrix[max - 1 - j - i][i] = matrix[max - 1 - i][max - 1 - j - i];
                matrix[max - 1 - i][max - 1 - j - i] = matrix[i + j][max - 1 - i];
                matrix[i + j][max - 1 - i] = temp;

            }
        }
        return matrix;

    }
}