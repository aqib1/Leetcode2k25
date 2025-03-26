class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1)
            return stones[0];

        var maxHeap = new PriorityQueue<Integer>(
                Comparator.reverseOrder()
        );

        for(int stone: stones)
            maxHeap.offer(stone);

        while(maxHeap.size() >= 2) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if(x != y) {
                y -= x;
                maxHeap.offer(y);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}