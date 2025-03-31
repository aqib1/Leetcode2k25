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
    public ListNode sortList(ListNode head) {
     if(head == null)
            return null;
        var minHeap = new PriorityQueue<ListNode>(
                Comparator.comparingInt(l -> l.val)
        );

        while(head != null) {
            minHeap.offer(head);
            head = head.next;
        }

        var response = minHeap.poll();
        var current = response;
        while (!minHeap.isEmpty()) {
            current.next = minHeap.peek();
            current = minHeap.poll();
        }
        current.next = null;

        return response;
    }
}