/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,4,5,6,0};
        int[] nums2 = new int[]{3};
        new MergeSortedArray_Solution().merge(nums1, 5, nums2, 1);
    }
}

class MergeSortedArray_Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m < 0){
            nums1 = nums2;
        }else if( n < 0){

        }else {
            int r1 = m - 1;
            int r2 = n - 1;
            for (int i = nums1.length - 1; i >= 0; i--) {
                if (r1 < 0) {
                    nums1[i] = nums2[r2];
                    r2--;
                } else if (r2 < 0) {
                    nums1[i] = nums1[r1];
                    r1--;
                } else {
                    if (nums1[r1] >= nums2[r2]) {
                        nums1[i] = nums1[r1];
                        r1--;
                    } else {
                        nums1[i] = nums2[r2];
                        r2--;
                    }
                }

            }
        }
    }
}
