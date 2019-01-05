/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class JumpGame {
    public static void main(String[] args) {
////        int[] nums = new int[]{3,2,1,0,4};
////        int[] nums = new int[]{2,3,1,1,4};
//        int[] nums = new int[]{2, 0, 0};
//        boolean result = new JumpGame_Solution().canJump(nums);
//        System.out.println("result: " + result);

        System.out.println(new JumpGame_Solution().canJump(new int[]{2,3,1,1,4}));
        System.out.println(new JumpGame_Solution().canJump(new int[]{3,2,1,0,4}));
        System.out.println(new JumpGame_Solution().canJump(new int[]{2,0}));
        System.out.println(new JumpGame_Solution().canJump(new int[]{2,3,1,1,4}));

    }
}

class JumpGame_Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1){
            return true;
        }
        int[] check = new int[nums.length];
        return tryJump(nums, check , 0);
    }

    public boolean tryJump(int[] nums, int[] check, int index){
        if (check[index] == 1 || nums[index] == 0){
            return false;
        }

        check[index] = 1;
        int length = nums.length - 1;
        for (int i = Math.min(nums[index], (length - index)); i > 0 ; i--){
            if (index + i == length){
                return true;
            }
            if (tryJump(nums, check , (index + i))){
                return true;
            }
        }

        return false;
    }
}