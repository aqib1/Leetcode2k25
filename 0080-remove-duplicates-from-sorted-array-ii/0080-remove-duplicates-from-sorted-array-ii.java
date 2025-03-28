class Solution {
    public int removeDuplicates(int[] nums) {
       if(nums.length == 1)
            return 1;
        // start with index 1
        int i = 1;
        int count = 1;

        for(int j = 1; j < nums.length; j++) {
            if(nums[j - 1] == nums[j])
                count++;
            else count = 1;

            if(count <= 2) {
                nums[i++] = nums[j];
            }
        }

        return i;
    }
}