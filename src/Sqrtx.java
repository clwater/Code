/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class Sqrtx {
    public static void main(String[] args) {
        System.out.println(new Sqrtx_Solution().mySqrt(4));
        System.out.println(new Sqrtx_Solution().mySqrt(16));
    }
}

class Sqrtx_Solution {
    public int mySqrt(int x) {
        double result = x;
        double last;
        do {
            last = result;
            result = (result + x / result) / 2;
        }while (Math.abs(last - result) > 0.00000001);
        return (int) result;
    }
}