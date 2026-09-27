class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        var result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            var count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] > nums[j]) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }
}