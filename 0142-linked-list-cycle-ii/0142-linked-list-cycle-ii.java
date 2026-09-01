/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
         if (head == null || head.next == null)
            return null;

        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                var ptr = head;

                while (slow != null && ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }

                return slow;
            }
        }
        return null;
    }
}