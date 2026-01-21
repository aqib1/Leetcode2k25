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
        while(l1 != null && l2 != null) {
            int compound = (l1.val + l2.val) + carry;

            sum.next = new ListNode(compound % 10);
            carry = compound / 10;

            l1 = l1.next;
            l2 = l2.next;
            sum = sum.next;
        }

        while(l1 != null) {
            int compound = l1.val + carry;

            sum.next = new ListNode(compound % 10);
            carry = compound / 10;
            sum = sum.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            int compound = l2.val + carry;

            sum.next = new ListNode(compound % 10);
            carry = compound / 10;
            sum = sum.next;
            l2 = l2.next;
        }

        if(carry != 0) sum.next = new ListNode(carry);

        return pointer.next;
    }
}