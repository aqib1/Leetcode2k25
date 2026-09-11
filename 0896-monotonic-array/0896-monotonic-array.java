class Solution {
    public boolean isMonotonic(int[] nums) {
        var increasing = false; var decreasing = false;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                increasing = true;
            } else if (nums[i] < nums[i - 1]) {
                decreasing = true;
            }

            if(increasing && decreasing)
                return false;
        }
        return true;
    }
}