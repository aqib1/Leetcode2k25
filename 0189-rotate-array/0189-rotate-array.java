class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        //reverse first k numbers
        reverse(nums, 0, k - 1);
        // reverse all except first k
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int i, int j) {
        while(i < j) {
            int tmp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = tmp;
        }
    }
}