class Solution {

    // Time complexity O(n)
    // Space complexity O(n)
    public int[] productExceptSelf(int[] nums) {
      int []result = new int[nums.length];
      var prefix = 1;
      for(int i = 0; i < nums.length; i++) {
        result[i] = prefix;
        prefix *= nums[i];
      }

      var suffix = 1;
      for(int i = nums.length - 1; i >= 0; i--) {
        result[i] *= suffix;
        suffix *= nums[i];
      }

      return result;
    }
}