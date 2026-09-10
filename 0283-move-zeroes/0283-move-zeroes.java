class Solution {
    public void moveZeroes(int[] nums) {
        var newNum = new int[nums.length];
        int i = 0;
        for(var n: nums) {
            if(n != 0)
                newNum[i++] = n;
        }
        System.arraycopy(newNum, 0, nums, 0, nums.length);
    }
}