class Solution {
    public void moveZeroes(int[] nums) {
       var prev = 0; var curr = 0;
        while(curr < nums.length) {
            if(nums[curr] == 0) {
                curr++;
            } else {
                var tmp = nums[curr];
                nums[curr] = nums[prev];
                nums[prev] = tmp;

                curr++;
                prev++;
            }
        }
    }
}