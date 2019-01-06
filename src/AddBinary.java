/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(new AddBinary_Solution().addBinary("11" , "1"));
    }
}

class AddBinary_Solution {
    public String addBinary(String a, String b) {
        char[] longStr;
        char[] shortStr;
        String result = "";

        int min;
        int max;
        if (a.length() >= b.length()){
            longStr = a.toCharArray();
            shortStr = b.toCharArray();
            min = b.length();
            max = a.length();
        }else {
            longStr = b.toCharArray();
            shortStr = a.toCharArray();
            min = a.length();
            max = b.length();
        }

        int next = 0;
        for (int i = min - 1; i >= 0; i--) {
            int sum = shortStr[i] - '0' + longStr[max - min + i] - '0' + next;
            result = "" + (sum % 2) + result;
            next = sum / 2;
        }
        for (int i = max - min - 1; i >= 0 ; i--) {
            int sum = longStr[i] - '0' + next;
            result = "" + (sum % 2) + result;
            next = sum / 2;
        }
        if (next > 0){
            result = "1" + result;
        }


        return result;
    }
}