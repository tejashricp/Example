package LinkedList;

/**
 * Reverse a Linked List in alternate K block of given size
 * i/p
 * 1->2->3->4->5->6->7->8->9->10
 *
 * o/p
 * 3->2->1->4->5->6->9->8->7->10
 *
 * i/p
 * 1->2->3->4->5->6->7->8->9->10->11
 *o/p
 * 3->2->1->4->5->6->9->8->7->10->11
 *
 * i/p
 * 1->2->3->4->5->6->7->8->9
 *o/p
 * 3->2->1->4->5->6->9->8->7
 *
 */
public class ReverseKAlternateBlocks {
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
        //node6.next = node7;
        //node7.next = node8;
        //node8.next = node9;
        //node9.next = node10;
        //node10.next = node11;
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
        boolean reverse = true;
        while (count <= k && node != null ) {
            if (reverse) {
                if (head == null && count == k)
                    head = node;//set head for new linked list
                else if (count == k)
                    lastOfPrevCycle.next = node;
                if (count == 1)
                    lastOfThisCycle = node;
                next = node.next;
                node.next = prev;
                prev = node;
                node = next;
                count++;
                if (count == k + 1) {
                    prev = null;
                    lastOfPrevCycle = lastOfThisCycle;
                    count = 1;
                    reverse = false;
                }
            }
            else
            {
                if(count == 1){
                    lastOfPrevCycle.next = node;
                }
                Node temp = node.next;
                prev = node;
                node = temp;
                next = node != null ? node.next:null;
                count++;
                if(count == k+1){
                    lastOfPrevCycle = prev;
                    count = 1;
                    reverse = true;
                }
            }
        }
        if(lastOfPrevCycle != null && count<=k && !reverse)
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

