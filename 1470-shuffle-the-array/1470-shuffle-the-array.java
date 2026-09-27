class Solution {
    public int[] shuffle(int[] nums, int n) {
        var result = new int[nums.length];
        var a = 0; var b = n;
        for(int i = 0; i < nums.length; i += 2) {
            result[i] = nums[a++];
            result[i + 1] = nums[b++];
        }
        return result;
    }
}