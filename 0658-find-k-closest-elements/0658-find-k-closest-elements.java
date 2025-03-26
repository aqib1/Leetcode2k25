class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
      var res = new ArrayList<Integer>();
            var minHeap = new PriorityQueue<Integer>((a, b) -> {
                int a_abs = Math.abs(a - x);
                int b_abs = Math.abs(b - x);
                if(a_abs == b_abs)
                    return a - b;
                else return a_abs - b_abs;
            });

            for(int a: arr) {
                minHeap.offer(a);
            }

            for(int i = 0; i < k; i++) {
                res.add(minHeap.poll());
            }

            return res.stream().sorted().toList();
    }
}