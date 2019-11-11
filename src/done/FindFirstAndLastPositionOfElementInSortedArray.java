/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * 二分查找优化
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
//        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] results = new FindFirstAndLastPositionOfElementInSortedArray_Solution()
                .searchRange(nums, 1);
        System.out.print("results[0]: " + results[0] + " results[1]: " + results[1]);
    }
}

class FindFirstAndLastPositionOfElementInSortedArray_Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] pos = {-1, -1};//初始化首位索引为-1，-1
        if (nums == null || nums.length == 0) return pos;
        FindIndex(pos, -1, target, nums);//寻找左界限
        FindIndex(pos, 1, target, nums);//寻找右界限
        return pos;
    }

    public void FindIndex(int[] pos, int direction, int target, int[] nums) {
        //初始化首尾指针，左/右界限
        int low = 0, high = nums.length - 1, index = (direction == 1) ? (nums.length - 1) : 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == index || nums[mid + direction] != target) {
                    //若mid为左/右界限或mid左/右移一位后就与target不相等，直接添加mid，跳出循环
                    int temp = (direction == 1) ? (pos[1] = mid) : (pos[0] = mid);
                    break;
                } else {
                    //若mid在target中，根据左右，判断首/尾指针移动，结束本次循环
                    int temp = (direction == 1) ? (low = mid + 1) : (high = mid - 1);
                    continue;
                }
            }
            //mid继续二分
            int k = (nums[mid] < target) ? (low = mid + 1) : (high = mid - 1);
        }
    }
}
