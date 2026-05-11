class Solution {
    public int[] twoSum(int[] nums, int target) {
        var complimentMap = new HashMap<Integer, Integer>();
        for(int n = 0; n < nums.length; n++) {
            int compliment = target - nums[n];
            if(complimentMap.containsKey(compliment)) {
                return new int[] {complimentMap.get(compliment), n};
            } else {
                complimentMap.put(nums[n], n);
            }
        }

        return null;
    }
}