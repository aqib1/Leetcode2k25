/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        var minHeap = new PriorityQueue<ListNode>(Comparator.comparingInt(l -> l.val));

        for(ListNode node: lists)
            if(node != null)
                minHeap.offer(node);

        var response = new ListNode();
        var ptr = response;

        while(!minHeap.isEmpty()) {
            var curr = minHeap.poll();
            if(curr.next != null) {
                minHeap.offer(curr.next);
            }
            ptr.next = curr;
            ptr = ptr.next;
        }

        return response.next;
    }
}