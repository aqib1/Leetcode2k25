class Solution {
    public int[] productExceptSelf(int[] nums) {
       int [] result = new int[nums.length];

        int prefix = 1;
        for(int n = 0; n < nums.length; n++) {
            result[n] = prefix;
            prefix *= nums[n];
        }

        int suffix = 1;
        for(int n = nums.length - 1; n >= 0; n--) {
            result[n] *= suffix;
            suffix *= nums[n];
        }

       return result;
    }
}