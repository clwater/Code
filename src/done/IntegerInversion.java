/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 *  示例 1:
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class IntegerInversion {
    public static void main(String[] args) {
        System.out.println(new IntegerInversion_Solution().reverse(123456789));
        System.out.println(new IntegerInversion_Solution().reverse(-123));
        System.out.println(new IntegerInversion_Solution().reverse(Integer.MAX_VALUE + 1));
        System.out.println(new IntegerInversion_Solution().reverse(Integer.MIN_VALUE - 1));
    }
}


class IntegerInversion_Solution {
    int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int index = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && index > 7)) {
                return 0;
            } else if (result < Integer.MIN_VALUE / 10 || (x == Integer.MIN_VALUE / 10 && index < -8)) {
                return 0;
            }
            result = result * 10 + index;
        }

        return result;
    }
}