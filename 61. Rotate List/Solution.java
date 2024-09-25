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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode ptr = head;
        int cnt = 0;

        while (ptr != null) {
            cnt++;
            ptr = ptr.next;
        }

        int rotateLength = k % cnt;
        if(rotateLength == 0) return head;

        int i = 0;
        ListNode cur = head;
        while (cur.next!=null) {
            i++;
            if(cnt -i == rotateLength) break;
            cur = cur.next;
        }

        ListNode nex = cur.next;
        cur.next=null;

        ListNode newHead = nex;

        while(nex.next!=null){
            nex=nex.next;
        } 
        nex.next=head;

        return newHead;
    }
}