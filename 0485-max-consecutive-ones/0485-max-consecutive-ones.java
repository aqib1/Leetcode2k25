class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int countOnes = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1)
                countOnes++;
            else countOnes = 0;

            max = Math.max(max, countOnes);
        }
        return max;
    }
}