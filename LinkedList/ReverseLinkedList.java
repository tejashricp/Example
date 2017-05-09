/**
 * Reverse a Linked List in groups of given size
 * i/p
 * 1->2->3->4->5->6->7->8->9->10
 *
 * o/p
 * 10-> 9-> 8-> 7-> 6-> 5-> 4-> 3-> 2-> 1
 *
 *
 */
public class Dev {
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

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        int k = 3;
        Node  node = reverseLinkedList(node1);
        printLinkedList(node);
    }

    private static void printLinkedList(Node node) {
        while(node != null){
            System.out.print(node.data+" ");
            node = node.next;
        }
    }

    private static Node reverseLinkedList(Node node1) {
        Node prev = null;
        Node next = node1.next;
        while(node1 != null){
             if(prev == null && next == null)
                return node1;
           
            node1.next = prev;
            Node temp2 = null;
            if(next != null) {
                temp2 =next.next;
                next.next = node1;
            }
            
            prev = node1;
            node1 = next;
            next = temp2;
        }

        return prev;
    }

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }


}

