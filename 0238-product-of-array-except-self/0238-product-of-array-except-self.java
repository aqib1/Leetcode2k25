class Solution {
    public int[] productExceptSelf(int[] nums) {
        var result = new int[nums.length];

        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            result[j] *= suffix;
            suffix *= nums[j];
        }

        return result;
    }
}