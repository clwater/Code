/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * <p>
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * <p>
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class ZigzagConversion {
    public static void main(String[] args) {
        String s = "012345678";
        System.out.println("3: " + new ZigzagConversion_Solution().convert(s, 3));
        System.out.println("4: " + new ZigzagConversion_Solution().convert(s, 4));
        System.out.println("5: " + new ZigzagConversion_Solution().convert(s, 5));
        System.out.println("5: " + new ZigzagConversion_Solution().convert(s, 2));
    }
}


class ZigzagConversion_Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        int length = s.length();
        StringBuffer result = new StringBuffer();
        int step = 2 * (numRows - 1);

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < length; j += step) {
                result.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + step - i < length){
                    result.append(s.charAt(j + step - i ));
                }
            }

        }

        return result.toString();

    }
}
