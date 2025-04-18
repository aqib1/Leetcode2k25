//0 <= key <= 10^6
public class MyHashSet {
    private static final int LIMIT = (int)Math.pow(10, 6) + 1;
    private final int[] set;
    public MyHashSet() {
        this.set = new int[LIMIT];
        Arrays.fill(set, -1);
    }

    public void add(int key) {
        set[key] = key;
    }

    public void remove(int key) {
        if(contains(key))
            set[key] = -1;
    }

    public boolean contains(int key) {
        return set[key] != -1;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */