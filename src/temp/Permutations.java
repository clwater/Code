package temp;

//
//给定一个没有重复数字的序列，返回其所有可能的全排列。
//
//        示例:
//
//        输入: [1,2,3]
//        输出:
//        [
//        [1,2,3],
//        [1,3,2],
//        [2,1,3],
//        [2,3,1],
//        [3,1,2],
//        [3,2,1]
//        ]

public class Permutations {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        List<List<Integer>> result = new Permutations_Solution().permute(nums);

        for (List<Integer> lists: result) {
            for (Integer temp: lists
                    ) {
                System.out.print(temp + " ,");
            }

            System.out.println("");
        }
    }
}

class Permutations_Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int length = nums.length - 1;
        if (length == 0){
            result.add(getList(nums));
            return result;
        }
        for (int i = 0; i <= length; i++) {
            for (int j = length ; j  > 0; j--) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                result.add(getList(nums));
            }
        }
        return result;
    }

    public List<Integer> getList(int[] nums){
        List<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
        }
        return temp;
    }
}