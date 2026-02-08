class Solution {

    // Time complexity O(n)
    // Space complexity O(1)
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;

        var max = nums[0]; var sum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            if(max < sum)
                max = sum;
        }

        return max;
      
    }
}