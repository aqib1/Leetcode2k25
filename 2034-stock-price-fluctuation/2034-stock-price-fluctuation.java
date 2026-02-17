class StockPrice {
    private int timestamp;
    private final Map<Integer, StockRecord> stockMap;
    private final Queue<StockRecord> minHeap;
    private final Queue<StockRecord> maxHeap;

    public StockPrice() {
        this.stockMap = new HashMap<>();
        this.minHeap = new PriorityQueue<>(Comparator.comparingInt(StockRecord::price));
        this.maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.price, a.price));
    }

    public void update(int timestamp, int price) {
        this.timestamp = Math.max(timestamp, this.timestamp);
        var stockRecord = new StockRecord(timestamp, price);
        this.stockMap.put(timestamp, stockRecord);
        this.minHeap.offer(stockRecord);
        this.maxHeap.offer(stockRecord);
    }

    public int current() {
        return stockMap.get(timestamp).price();
    }

    public int maximum() {
        while (!maxHeap.isEmpty() && (maxHeap.peek().price != stockMap.get(maxHeap.peek().timestamp).price)) {
            maxHeap.poll();
        }

        return maxHeap.isEmpty() ? -1 : maxHeap.peek().price;
    }

    public int minimum() {
        while (!minHeap.isEmpty() && (minHeap.peek().price != stockMap.get(minHeap.peek().timestamp).price)) {
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