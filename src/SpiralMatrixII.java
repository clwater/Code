/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrixII {
    public static void main(String[] args) {
        int[][] result = new SpiralMatrixII_Solution().generateresult(3);
        for (int[] ints : result){
            for (int index: ints){
                System.out.print(" " + index);
            }
            System.out.println("");
        }

    }
}


class SpiralMatrixII_Solution {
    public int[][] generateresult(int n) {
        int[][] result = new int[n][n];
        int index = 1;
        for (int deep = 0; deep < n; deep++) {
            for (int i = 0; i < n - 2 * deep - 1; i++) {
                result[deep][i + deep] = index++;
            }

            for (int i = 0; i < n - 2 * deep - 1; i++) {
                result[deep + i][n - deep - 1] = index++;
            }
            
            for (int i = n - 2 * deep - 1; i > 0; i--) {
                result[n - deep - 1][i + deep] = index++;
            }

            for (int i = 0; i < n - 2 * deep - 1; i++) {
                result[n - deep - i - 1][deep] = index++;
            }
        }
        if (n % 2 == 1){
            result[n / 2][n / 2] = index;
        }
        return result;
    }
}