import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        var queue = new PriorityQueue<String>(k, (a, b) -> {
            if(a.length() != b.length()) {
                return Integer.compare(a.length(), b.length());
            }
            return a.compareTo(b);
        });

        for(var num: nums) {
            queue.offer(num);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }
}