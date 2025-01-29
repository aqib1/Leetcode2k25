class Solution {
    public int singleNumber(int[] nums) {
        int zero = 0;
        for(int n : nums) zero ^= n;

        return zero;
    }
}