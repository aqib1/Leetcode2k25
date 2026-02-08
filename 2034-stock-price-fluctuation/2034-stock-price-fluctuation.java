class StockPrice {
    private int maxTimestamp;
    private final Map<Integer, StockRecord> stockMap;
    private final Queue<StockRecord> minHeap;
    private final Queue<StockRecord> maxHeap;

    // Time complexity ON(LogN)
    // Space complexity O(N)
    public StockPrice() {
        maxTimestamp = Integer.MIN_VALUE;
        stockMap = new HashMap<>();
        minHeap = new PriorityQueue<>(Comparator.comparing(StockRecord::price));
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.price, a.price));
    }

    public void update(int timestamp, int price) {
        maxTimestamp = Math.max(maxTimestamp, timestamp);
        var stockRecord = new StockRecord(timestamp, price);
        stockMap.put(timestamp, stockRecord);
        minHeap.offer(stockRecord);
        maxHeap.offer(stockRecord);
    }

    public int current() {
        return stockMap.get(maxTimestamp).price;
    }

    public int maximum() {
        if (maxHeap.isEmpty())
            return -1;

        while (!maxHeap.isEmpty() && maxHeap.peek().price != stockMap.get(maxHeap.peek().timestamp).price) {
            maxHeap.poll();
        }

        return maxHeap.isEmpty() ? -1 : maxHeap.peek().price;
    }

    public int minimum() {
        if (minHeap.isEmpty())
            return -1;

        while (!minHeap.isEmpty() && minHeap.peek().price != stockMap.get(minHeap.peek().timestamp).price) {
            minHeap.poll();
        }

        return minHeap.isEmpty() ? -1 : minHeap.peek().price;
    }

    record StockRecord(int timestamp, int price) {

    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */