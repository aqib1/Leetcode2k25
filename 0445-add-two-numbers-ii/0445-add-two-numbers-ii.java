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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var r1 = reverse(l1);
        var r2 = reverse(l2);
        var sum = new ListNode();
        var ptr = sum;
        var carr = 0;
        while (r1 != null || r2 != null || carr != 0) {
            var add = carr;
            if (r1 != null) {
                add += r1.val;
                r1 = r1.next;
            }
            if (r2 != null) {
                add += r2.val;
                r2 = r2.next;
            }
            sum.next = new ListNode(add % 10);
            carr = add / 10;
            sum = sum.next;
        }
        return reverse(ptr.next);
    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null;

        while (curr != null) {
            var next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
}