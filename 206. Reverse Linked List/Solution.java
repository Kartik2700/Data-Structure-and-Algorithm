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
    public ListNode reverseList(ListNode head) {

        if (head ==null || head.next == null )
            return head;
        if (head.next.next == null) {
            ListNode ptr = head.next;
            ptr.next = head;
            head.next = null;
            return ptr;
        }

        ListNode back = head;
        ListNode curr = back.next;
        ListNode front = curr.next;

        while (front != null) {
            curr.next = back;
            back = curr;
            curr = front;
            front = front.next;
        }
        curr.next = back;
        head.next = null;
        return curr;
    }
}