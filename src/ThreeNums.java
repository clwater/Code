import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 *  例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeNums {
    public static void main(String[] args){
        List<List<Integer>> result = new ThreeNums_Solution().threeSum(new int[]{-1,0,1,2,-1,-4});
        for (List<Integer> lists : result){
            for (Integer integer : lists){
                System.out.print(" " + integer);
            }
            System.out.print("\n");
        }
    }
}

class ThreeNums_Solution{
    List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++){
            int l = i + 1, r = nums.length -1;
            while (l < r){
                if (nums[i] + nums[l] + nums[r] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    if (!result.contains(list)){
                        result.add(list);
                    }
                }
                if (nums[i] + nums[l] + nums[r] < 0){
                    l++;
                }else {
                    r--;
                }
            }
        }
        return result;
    }
}

