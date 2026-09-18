import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public double average(int[] salary) {
       var minHeap = new PriorityQueue<int[]>(
                Comparator.comparingInt(a -> a[1])
        );

        var maxHeap = new PriorityQueue<int[]>(
                (a, b) -> Integer.compare(b[1], a[1])
        );

        for(int i = 0; i < salary.length; i++) {
            minHeap.offer(new int[]{i, salary[i]});
            maxHeap.offer(new int[] {i, salary[i]});
        }

        var min = minHeap.poll();
        var max = maxHeap.poll();
        var sum = 0;
        for(int i = 0; i < salary.length; i++) {
            if(i != min[0] && i != max[0]) {
                sum += salary[i];
            }
        }
        return (double) sum / (salary.length - 2); 
    }
}