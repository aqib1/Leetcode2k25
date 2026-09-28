class MyStack {
    private final Queue<Integer> fifo;

    public MyStack() {
        this.fifo = new LinkedList<>();
    }

    public void push(int x) {
        fifo.add(x);

        for(int i = 0; i < fifo.size() - 1; i++) {
            fifo.add(fifo.remove());
        }
    }

    public int pop() {
        if(fifo.isEmpty())
            return -1;
        return fifo.poll();
    }

    public int top() {
        if(fifo.isEmpty())
            return -1;
        return fifo.peek();
    }

    public boolean empty() {
        return fifo.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */