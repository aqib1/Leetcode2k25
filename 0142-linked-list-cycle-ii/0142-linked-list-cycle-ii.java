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
    // Time complexity O(n)
    // Space complexity O(1)
    public ListNode detectCycle(ListNode head) {
         if(head == null || head.next == null)
            return null;
        
        var slow = head; var fast = head;

        do {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                break;

        } while(fast != null && fast.next != null);

        if(slow != fast)
            return null;

        slow = head;

        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}