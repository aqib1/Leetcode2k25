class StockSpanner {

    private final Queue<int[]> minHeap;

    public StockSpanner() {
        this.minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
    }

    public int next(int price) {
        int span = 1;
        while (!minHeap.isEmpty() && minHeap.peek()[0] <= price) {
            span += minHeap.poll()[1];
        }

        minHeap.offer(new int[]{price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */