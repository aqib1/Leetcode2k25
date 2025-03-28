class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1)
            return 1;
        int slow = 1, fast = 1;

        while (fast < nums.length) {
            if (nums[slow - 1] == nums[fast]) {
                fast++;
            } else {
                nums[slow++] = nums[fast++];
            }
        }

        return slow;

    }
}