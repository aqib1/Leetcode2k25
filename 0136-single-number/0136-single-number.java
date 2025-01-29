class Solution {
    // Time O(n) and space O(1)
    public int singleNumber(int[] nums) {
        int number = 0;
        for(int n: nums) number ^= n;
        return number;
    }
}