class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        var nIndexMap = new HashMap<Integer, List<Integer>>();
        var result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            var indexes = nIndexMap.getOrDefault(nums[i], new ArrayList<>());
            indexes.add(i);
            nIndexMap.put(nums[i], indexes);
        }

        Arrays.sort(nums);

        int count = 0;
        for (int i = 0; i < nums.length;) {
            var indexes = nIndexMap.get(nums[i]);
            if (indexes.size() == 1) {
                result[indexes.getFirst()] = count;
                count++;
                i++;
            } else {
                var c = count;
                for (int index : indexes) {
                    result[index] = c;
                    i++;
                    count++;
                }
            }

        }

        return result;
    }
}