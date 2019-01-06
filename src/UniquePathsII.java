/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 说明：m 和 n 的值均不超过 100。
 * 示例 1:
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{
                {0, 1, 0},
                {1, 1, 0},
                {0, 0, 0},
//                {0}, {1}
        };
        System.out.println(new UniquePathsII_Solution().uniquePathsWithObstacles(obstacleGrid));
    }
}

class UniquePathsII_Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1){
                for (int j = i; j < m; j++) {
                    obstacleGrid[j][0] = 1;
                }
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1){
                for (int j = i; j < n; j++) {
                    obstacleGrid[0][j] = 1;
                }
                break;
            }
        }

        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    if (obstacleGrid[i][j] == 1){
                        result[i][j] = 0;
                    }else {
                        result[i][j] = 1;
                    }
                } else {
                    int index = 0;
                    if (obstacleGrid[i - 1][j] != 1) {
                        index += result[i - 1][j];
                    }
                    if (obstacleGrid[i][j - 1] != 1) {
                        index += result[i][j - 1];
                    }
                    result[i][j] = index;
                }
            }
        }

        return result[m - 1][n - 1];
    }
}