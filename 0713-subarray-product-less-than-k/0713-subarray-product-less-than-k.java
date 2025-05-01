class Solution {
    // Time complexity O(n) and space O(1)
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int product = 1;
        int count = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            product *= nums[end];

            while (product >= k) {
                product /= nums[start++];
            }

            count += (end - start) + 1;
        }

        return count;
    }
}