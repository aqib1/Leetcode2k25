class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        var result = new int[k];
        var minHeap = new PriorityQueue<Integer>(k);

        for(int num: nums) {
            minHeap.offer(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int index = 0;
        for(int num: nums) {
            if(k == 0)
                break;
            if(minHeap.contains(num)) {
                result[index++] = num;
                minHeap.remove(num);
                k--;
            }
        }

        return result;
    }
}