class Solution {
    public int[] twoSum(int[] nums, int target) {
        var countMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(countMap.containsKey(complement)) {
                return new int[] { countMap.get(complement), i };
            }
            countMap.put(nums[i], i);
        }
        return new int[] {};
    }
}