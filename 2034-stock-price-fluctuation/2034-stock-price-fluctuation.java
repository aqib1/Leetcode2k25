class StockPrice {
    // Space O(N)
    private int lastestTimestamp;
    private final Map<Integer, StockRecord> stockMap;
    private final Queue<StockRecord> minHeap;
    private final Queue<StockRecord> maxHeap;

    public StockPrice() {
        this.stockMap = new HashMap<>();
        this.minHeap = new PriorityQueue<>(Comparator.comparingInt(StockRecord::price));
        this.maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.price, a.price));
    }

    // OLog(N) if heapify then ON(LogN)
    public void update(int timestamp, int price) {
        lastestTimestamp = Math.max(lastestTimestamp, timestamp);
        var stockRecord = new StockRecord(timestamp, price);

        stockMap.put(timestamp, stockRecord);
        minHeap.offer(stockRecord);
        maxHeap.offer(stockRecord);
    }

    // O(1)
    public int current() {
        return stockMap.get(lastestTimestamp).price;
    }

    // OLog(N)
    public int maximum() {
        if(stockMap.isEmpty())
            return -1;

        while(!maxHeap.isEmpty() && maxHeap.peek().price != stockMap.get(maxHeap.peek().timestamp).price) {
            maxHeap.poll();
        }

        return maxHeap.isEmpty() ? -1 : maxHeap.peek().price;
    }

    // OLog(N)
    public int minimum() {
        if(stockMap.isEmpty())
            return -1;

        while(!minHeap.isEmpty() && minHeap.peek().price != stockMap.get(minHeap.peek().timestamp).price) {
            minHeap.poll();
        }

        return minHeap.isEmpty() ? -1 : minHeap.peek().price;
    }

    record StockRecord(int timestamp, int price) {}
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */