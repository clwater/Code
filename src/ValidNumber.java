/**
 * 验证给定的字符串是否为数字。
 *
 * 例如:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 */
public class ValidNumber {
    public static void main(String[] args) {
        System.out.println(new ValidNumber_Solution().isNumber("0"));
        System.out.println(new ValidNumber_Solution().isNumber("0.1"));
        System.out.println(new ValidNumber_Solution().isNumber("abc"));
        System.out.println(new ValidNumber_Solution().isNumber("1 a"));
        System.out.println(new ValidNumber_Solution().isNumber("2e10"));
        System.out.println(new ValidNumber_Solution().isNumber(" -90e3   "));
        System.out.println(new ValidNumber_Solution().isNumber(" 1e"));
        System.out.println(new ValidNumber_Solution().isNumber(" 6e-1"));
        System.out.println(new ValidNumber_Solution().isNumber(" 99e2.5 "));
        System.out.println(new ValidNumber_Solution().isNumber("53.5e93"));
        System.out.println(new ValidNumber_Solution().isNumber(" --6 "));
        System.out.println(new ValidNumber_Solution().isNumber("-+3"));
        System.out.println(new ValidNumber_Solution().isNumber("95a54e53"));
    }
}


class ValidNumber_Solution {
    public boolean isNumber(String s) {
        return s.trim().matches("[-+]?(\\d+\\.?|\\.\\d+)\\d*([-+]?\\d+)?");
    }
}




