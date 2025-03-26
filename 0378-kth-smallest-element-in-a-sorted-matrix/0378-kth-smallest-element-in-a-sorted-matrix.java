class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        var maxHeap = new PriorityQueue<Integer>(k, Comparator.reverseOrder());

        for(int []m : matrix) {
            for(int i: m) {
                maxHeap.offer(i);
                if(maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}