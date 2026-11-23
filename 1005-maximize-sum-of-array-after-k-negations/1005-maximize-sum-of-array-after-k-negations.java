import java.util.*;
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        var minHeap = new PriorityQueue<Integer>();
        for(int n: nums) {
            minHeap.offer(n);
        }

        while(k-- > 0) {
            minHeap.offer(-minHeap.poll());
        }

        int sum = 0;
        while(!minHeap.isEmpty()) {
            sum += minHeap.poll();
        }
        return sum;
    }
}