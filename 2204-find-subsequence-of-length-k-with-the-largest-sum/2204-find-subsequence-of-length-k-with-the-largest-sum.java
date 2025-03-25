class Solution {
    // Time ON(LogK) and space O(K)
    public int[] maxSubsequence(int[] nums, int k) {
        var result = new int[k];
        var minHeap = new PriorityQueue<int[]>(k, Comparator.comparingInt(a -> a[0]));
        for(int i = 0; i < nums.length; i++) {
            minHeap.offer(new int[] {nums[i], i});
            if(minHeap.size() > k) {
                minHeap.poll(); // keep memory limited to k
            }
        }
        var indexes = new HashSet<Integer>();
        while(!minHeap.isEmpty()) {
            indexes.add(minHeap.poll()[1]);
        }

        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(indexes.contains(i)) {
                result[index++] = nums[i];
            }
        }
        return result;
    }
}