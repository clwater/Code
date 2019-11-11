import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 */
public class ValidSudoku {
    public static void main(String[] args) {
        char[][] boadr = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.print(new ValidSudoku_Solution().isValidSudoku(boadr));
    }
}

class ValidSudoku_Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> hor = new ArrayList<>();
        List<Set<Character>> ver = new ArrayList<>();
        List<Set<Character>> group = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            hor.add(new HashSet<>());
            ver.add(new HashSet<>());
            group.add(new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.'){
                    continue;
                }

                if (hor.get(i).contains(c)) {
                    return false;
                } else {
                    hor.get(i).add(c);
                }

                if (ver.get(j).contains(c)) {
                    return false;
                } else {
                    ver.get(j).add(c);
                }
                int index = (i / 3) * 3 + (j / 3);
                if (group.get(index).contains(c)) {
                    return false;
                } else {
                    group.get(index).add(c);
                }
            }
        }
        return true;

    }
}