/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode ans = new ListNode();
        ListNode ptr = ans;

        while (l1 != null || l2 != null || carry != 0) {
            int num1 = 0, num2 = 0;

            if (l1 != null)
                num1 = l1.val;
            else
                num1 = 0;
            if (l2 != null)
                num2 = l2.val;
            else
                num2 = 0;

            int sum = num1 + num2 + carry;

            int digit = sum % 10;
            carry = sum / 10;

            ListNode result = new ListNode(digit);

            ptr.next = result;

            ptr = ptr.next;

            if (l1 != null)
                l1 = l1.next;
            else
                l1 = null;
            if (l2 != null)
                l2 = l2.next;
            else
                l2 = null;

        }

        ptr.next = null;

        return ans.next;

    }
}