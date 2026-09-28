class MyQueue {
    private final Stack<Integer> s1;
    private final Stack<Integer> s2;

    public MyQueue() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    // 2, 3, 4
    // 4, 3, 2
    public int pop() {
        if (s1.isEmpty())
            return -1;
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        var pop = s2.pop();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return pop;
    }

    public int peek() {
        if (s1.isEmpty())
            return -1;
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        var peek = s2.peek();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return peek;
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */