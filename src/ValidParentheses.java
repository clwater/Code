import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class ValidParentheses {
    public static void main(String[] args){
        System.out.println(new ValidParentheses_Solution().isValid("()"));
        System.out.println(new ValidParentheses_Solution().isValid("()[]{}"));
        System.out.println(new ValidParentheses_Solution().isValid("(]"));
        System.out.println(new ValidParentheses_Solution().isValid("([)]"));
        System.out.println(new ValidParentheses_Solution().isValid("{[]}"));
    }
}

class ValidParentheses_Solution {
    public boolean isValid(String s) {
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()){
            if (c == '(' || c == '[' || c == '{'){
                list.add(c);
            }else {
                if (list .size() == 0){
                    return false;
                }
                char last = list.get(list.size() - 1);
                switch (c){
                    case ')':
                        if (last == '('){
                            list.remove(list.size() - 1);
                        }else {
                            return false;
                        }
                        break;
                    case ']':
                        if (last == '['){
                            list.remove(list.size() - 1);
                        }else {
                            return false;
                        }
                        break;
                    case '}':
                        if (last == '{'){
                            list.remove(list.size() - 1);
                        }else {
                            return false;
                        }
                }
            }
        }

        return list.size() == 0;
    }
}