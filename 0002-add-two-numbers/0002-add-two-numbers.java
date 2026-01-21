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
        ListNode sum = new ListNode(0);
        ListNode pointer = sum;
        int carry = 0;

        while(l1 != null || l2 != null) {
            int compound = carry;
            if(l1 != null) {
                compound += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                compound += l2.val;
                l2 = l2.next;
            }

            sum.next = new ListNode(compound % 10);
            carry = compound / 10;
            sum = sum.next;
        }

        if(carry != 0) sum.next = new ListNode(carry);
        return pointer.next;
    }
}