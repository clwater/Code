/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaximumSubarray {
    public static void main(String[] args){
//        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = new int[]{1};
        System.out.println(new MaximumSubarray_Solution().maxSubArray(nums));

    }
}

class MaximumSubarray_Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = 0;
        for (int i = 0 ; i < nums.length ; i++){
            if (sum > 0){
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            if (sum > result){
                result = sum;

            }
        }

        return result;
    }
}