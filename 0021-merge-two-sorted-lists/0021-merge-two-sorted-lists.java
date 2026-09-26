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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)
            return null;
        if(list1 == null || list2 == null)
            return list1 == null ? list2 : list1;

        var minHeap = new PriorityQueue<ListNode>(Comparator.comparingInt(l -> l.val));
        minHeap.offer(list1);
        minHeap.offer(list2);
        var response = new ListNode();
        var ptr = response;

        while (!minHeap.isEmpty()) {
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