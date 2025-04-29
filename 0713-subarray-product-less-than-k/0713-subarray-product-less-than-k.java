class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
       if(k <= 1)
            return 0;

        int product = 1;
        int countSubArray = 0;

        for(int start = 0, end = 0; end < nums.length; end++) {
            product *= nums[end];

            while(product >= k) {
                product /= nums[start++];
            }

            countSubArray += (end - start) + 1;
        }

        return countSubArray;
    }
}