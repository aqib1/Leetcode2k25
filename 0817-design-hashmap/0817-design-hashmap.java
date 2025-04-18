class MyHashMap {
    private static final int LIMIT = (int)Math.pow(10, 6) + 1;
    private final int[] map;
    public MyHashMap() {
        this.map = new int[LIMIT];
        Arrays.fill(map, - 1);
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        return map[key];
    }

    public void remove(int key) {
        if(map[key] != -1) {
            map[key] = -1;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */