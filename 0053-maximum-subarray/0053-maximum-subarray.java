class Solution {
    public int maxSubArray(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0)
            return -1;
        int max = nums[0], sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);

            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }
}