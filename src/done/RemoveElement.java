/**
 * Create by clwater on 2018/12/30.
 */
class RemoveElement {
   public static void main(String[] args){
       int[] nums = new int[]{0,1,2,2,3,0,4,2};
       int length =  new RemoveElement_Solution().removeElement( nums, 2);
       for (int i = 0 ; i < length; i++){
           System.out.print(nums[i] + " , ");
       }
   }
}

class RemoveElement_Solution {
    public int removeElement(int[] nums, int val) {
        int l = 0;
        int r = nums.length;
        while (l < r){
            if (nums[l] == val){
                nums[l] = nums[r - 1];
                r--;
            }else {
                l++;
            }
        }
        return r;
    }
}