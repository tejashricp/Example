package LinkedList;

/**
 * Reverse a Linked List in groups of given size
 * i/p
 * 1->2->3->4->5->6->7->8->9->10
 *
 * o/p
 * 3->2->1->6->5->4->9->8->7->10
 *
 * i/p
 * 1->2->3->4->5->6->7->8->9->10->11
 *o/p
 * 3->2->1->6->5->4->9->8->7->11->10
 *
 * i/p
 * 1->2->3->4->5->6->7->8->9
 *o/p
 * 3->2->1->6->5->4->9->8->7
 *
 */
public class ReverseKBlock {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        int k = 3;
        Node  node = reverseKAlternateBlock(node1,k);
        printLinkedList(node);
    }

    private static void printLinkedList(Node node) {
        while(node != null){
            System.out.print(node.data+" ");
            node = node.next;
        }
    }

    private static Node reverseKAlternateBlock(Node node,int k){
        int count = 1;
        Node prev = null;
        Node next = null;
        Node head = null;
        Node lastOfThisCycle = null;
        Node lastOfPrevCycle = null;
        while (count <= k && node != null) {
            if(head == null && count == k)
                head = node;//set head for new linked list
            else if(count == k )
                lastOfPrevCycle.next = node;
            if(count == 1)
                lastOfThisCycle = node;
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
            count++;
            if(count == k+1) {
                prev = null;
                lastOfPrevCycle = lastOfThisCycle;
                count = 1;
            }
        }
        if(lastOfPrevCycle != null)
            lastOfPrevCycle.next = prev;
        if(head == null)
            head = prev;
        return head;

    }
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }


}

