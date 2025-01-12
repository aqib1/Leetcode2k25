class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
      var redBlackTree = new TreeSet<Integer>();
            for(int i = 0; i < nums.length; i++) {
                // abs(nums[i] - nums[j]) <= valueDiff
                Integer successor = redBlackTree.ceiling(nums[i]);
                if(successor != null && Math.abs(nums[i] - successor) <= t)
                    return true;

                Integer predecessor = redBlackTree.floor(nums[i]);
                if(predecessor != null && Math.abs(predecessor - nums[i]) <= t)
                    return true;

                redBlackTree.add(nums[i]);
                if(redBlackTree.size() > k) {
                    redBlackTree.remove(nums[i - k]);
                }

            }
            return false;
    }

}