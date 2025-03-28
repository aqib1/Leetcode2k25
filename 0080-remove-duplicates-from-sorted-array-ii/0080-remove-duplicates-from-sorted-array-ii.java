class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2)
            return 2;
        int slow = 2, fast = 2;
        while(fast < nums.length) {
            if(nums[slow - 2] == nums[fast]) {
                fast++;
            } else {
                nums[slow++] = nums[fast++];
            }
        }

        return slow;
    }
}