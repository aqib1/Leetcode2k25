class Solution {
    public int[] getConcatenation(int[] nums) {
        var response = new int[2 * nums.length];
        for (int i = 0; i < nums.length; i++) {
            response[i] = nums[i];
            response[i + nums.length] = nums[i];
        }
        return response;
    }
}