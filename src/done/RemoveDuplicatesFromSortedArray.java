/**
 * Create by clwater on 2018/12/28.
 */
class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args){
//        int[] nums = new int[]{0,0,1,1,2,3,4};
        int[] nums = new int[]{1,1,2};
        int index = new RemoveDuplicatesFromSortedArray_Solution().removeDuplicates(nums);
        System.out.println(index);
        for (int i = 0; i < index; i++){
            System.out.print("" + nums[i] + "  ");
        }
    }
}


class RemoveDuplicatesFromSortedArray_Solution {
    public int removeDuplicates(int[] nums) {
        int result = 0;
        for (int index = 0; index < nums.length ; index++){
            if (nums[result] != nums[index]){
                result++;
                nums[result] = nums[index];
            }
        }
        return result +1;
    }
}