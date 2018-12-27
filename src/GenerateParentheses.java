import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParentheses {
    public static void main(String[] args){
        List<String> results = new GenerateParentheses_Solution().generateParenthesis(3);
        for (String s : results){
            System.out.println(s);
        }
    }
}


class GenerateParentheses_Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0 , 0 , n);
        return result;
    }

    public void backtrack(List<String> ans, String cur, int left, int right, int max){
        if (cur.length() == 2 * max){
            ans.add(cur);
            return;
        }

        if (left < max){
            backtrack(ans, cur + "(" , left + 1, right, max);
        }
        if (right < left){
            backtrack(ans, cur + ")" , left , right + 1, max);

        }
    }
}
