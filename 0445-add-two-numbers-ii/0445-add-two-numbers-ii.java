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
        var s1 = new Stack<Integer>();
        var s2 = new Stack<Integer>();
        var sum = new ListNode();
        var ptr = sum;
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        var carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            var add = carry;

            if (!s1.isEmpty())
                add += s1.pop();
            if (!s2.isEmpty())
                add += s2.pop();

            sum.next = new ListNode(add % 10);
            carry = add / 10;
            sum = sum.next;
        }

        return previous(ptr.next);
    }

    public ListNode previous(ListNode node) {
        ListNode curr = node, prev = null;
        while (curr != null) {
            var next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }
}