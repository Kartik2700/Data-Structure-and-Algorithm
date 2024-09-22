/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode givenNode) {
        ListNode nextNode = givenNode.next;

        int currVal = givenNode.val;
        givenNode.val=nextNode.val;
        nextNode.val=currVal;

        nextNode = nextNode.next;
        givenNode.next=nextNode;


    }
}