class Solution {
    // Time complexity On(logn) + O(n) = O2n(logn) = Onlogn
    // Space O(n)
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 1; i--) {
            if (nums[i - 1] + nums[i - 2] > nums[i])
                return nums[i] + nums[i - 1] + nums[i - 2];
        }
        return 0;
    }
}