class Solution {
    public int subarraySum(int[] nums, int k) {
        var prefixSum = 0;
        var count = 0;
        var prefixSumMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
            prefixSum += n;

            if (prefixSumMap.containsKey(prefixSum - k)) {
                count += prefixSumMap.get(prefixSum - k);
            }
        }

        return count;
    }
}