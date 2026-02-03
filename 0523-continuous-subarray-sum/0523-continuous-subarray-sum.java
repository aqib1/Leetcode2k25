class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        var modIndexMap = new HashMap<Integer, Integer>();
        var prefixMode = 0;

        modIndexMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefixMode = (prefixMode + nums[i]) % k;

            if (modIndexMap.containsKey(prefixMode)) {
                if (i - modIndexMap.get(prefixMode) > 1) {
                    return true;
                }
            } else
                modIndexMap.put(prefixMode, i);
        }
        return false;
    }
}