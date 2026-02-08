class StockSpanner {
    private final Queue<int[]> minHeap;

    public StockSpanner() {
        this.minHeap = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[1]));
    }


    // Time complexity O(LogN) and heapify ON(LogN)
    // Space complexity O(N)
    public int next(int price) {
        int span = 1;
        while (!minHeap.isEmpty() && price >= minHeap.peek()[1]) {
            span += minHeap.poll()[0];
        }
        minHeap.offer(new int[] { span, price });
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */