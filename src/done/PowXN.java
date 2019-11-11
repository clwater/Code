/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class PowXN {
    public static void main(String[] args){
        double d = new PowXN_Solution().myPow(2, -3);
        System.out.println("" + d);

    }
}

class PowXN_Solution {
    public double myPow(double x, int n) {
        if (n == 0){
            return 1;
        }
        if (x == 0){
            return 0;
        }

        if (n < 0){
            return 1 / x * myPow(1 / x, -(n + 1));
        }else {
            double d = myPow(x, n / 2);
            if (n % 2 == 0) {
                return d * d;
            } else {
                return d * d * x;
            }
        }
    }
}