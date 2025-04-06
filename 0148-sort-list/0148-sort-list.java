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
    // Time complexity ON(logN) and Space O(n)
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode mid = mid(head);
        ListNode nextToMid = mid.next;
        mid.next = null; // making mid half of list

        ListNode left = sortList(head);
        ListNode right = sortList(nextToMid);

        return merge(left, right);    
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode ptr = dummy;
        
        while(left != null && right != null) {
            if(left.val <= right.val) {
                ptr.next = left;
                left = left.next;
            } else {
                ptr.next = right;
                right = right.next;
            }
            ptr = ptr.next;
        }

        if(left != null) ptr.next = left;
        if(right != null) ptr.next = right;

        return dummy.next;
    }

    public ListNode mid(ListNode head) {
        if(head == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;    
    }
}