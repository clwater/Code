/**
 * 定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = new int[]{9,9};
        int[] result =  new PlusOne_Solution().plusOne(digits);
        for (int i = 0; i < result.length; i++) {
            System.out.print("" + result[i] + ", ");
        }

    }
}

class PlusOne_Solution {
    public int[] plusOne(int[] digits) {
        int next = 0;
        for (int i = digits.length - 1; i >= 0 ; i--) {
            if (i == digits.length - 1){
                int sum = digits[i] + 1 + next;
                digits[i] = sum % 10;
                next = sum / 10;
            }else {
                int sum = digits[i] + next;
                digits[i] = sum % 10;
                next = sum / 10;
            }
        }
        int[] result;
        if (next > 0){
            result = new int[digits.length + 1];
            result[0] = next;
            for (int i = 0; i < digits.length - 1; i++) {
                result [i + 1] = digits[i];
            }

            return result;
        }else {
            return digits;
        }
    }
}
