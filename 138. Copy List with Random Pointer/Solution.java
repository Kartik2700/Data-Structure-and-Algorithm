/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    private void createACopy(Node head) {
        Node ptr = head;

        while (ptr != null) {
            Node newCopyNode = new Node(ptr.val);
            Node nextNode = ptr.next;

            newCopyNode.next = nextNode;

            ptr.next = newCopyNode;
            ptr = nextNode;
        }
    }

    private void connectRandomPointer(Node head) {
        Node ptr = head;

        while (ptr != null) {
            Node copiedNode = ptr.next;
            //ptr.random.next -> bcz ptr.random points to orignal list but we need to map the copied node which are present
            //next to tha orignal Node which random pointer is pointing 
            if(ptr.random!=null){
                copiedNode.random = ptr.random.next;
            }
            else{
                copiedNode.random =null;
            }

            ptr = copiedNode.next;
        }
    }

    private Node getCopiedList(Node head){
        Node dummy  = new Node(-1);
        Node temp =dummy;
        Node ptr = head;

        while(ptr!=null){
            temp.next=ptr.next;
            temp=temp.next;
            ptr.next = temp.next;
            ptr=ptr.next;

        }
        return dummy.next;
    }

    public Node copyRandomList(Node head) {

        if (head == null)
            return head;

        createACopy(head);

        connectRandomPointer(head);

        Node dummy = getCopiedList(head);

        return dummy;

    }
}