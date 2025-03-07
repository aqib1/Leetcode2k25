import java.util.AbstractMap;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        var maxHeap = new PriorityQueue<Map.Entry<int[], Double>>(
                (e1, e2) -> Double.compare(e2.getValue(), e1.getValue()));
        var result = new int[k][2];
        for (int[] point : points) {
            // we need to find distance of each point from origin (0,0)
            var distance = Math.sqrt(
                    Math.pow(point[0], 2) + Math.pow(point[1], 2));
            if (maxHeap.size() < k)
                maxHeap.offer(new AbstractMap.SimpleEntry<>(point, distance));
            else if (maxHeap.peek().getValue() > distance) {
                maxHeap.poll();
                maxHeap.offer(new AbstractMap.SimpleEntry<>(point, distance));
            }
        }

        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            result[i] = maxHeap.poll().getKey();
        }

        return result;
    }
}