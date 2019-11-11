/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(new ClimbingStairs_Solution().climbStairs(44));
        System.out.println(new ClimbingStairs_Solution().climbStairs(3));
    }
}

class ClimbingStairs_Solution {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            int temp = a;
            a = b;
            b += temp;
        }
        return b;
    }

//
//    public int climbStairs(int n) {
//        if ( n == 1 || n == 2) {
//            return 1;
//        } else {
//            return f(n - 1) + f(n - 2);
//        }
//    }
}