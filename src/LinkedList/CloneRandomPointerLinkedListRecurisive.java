import java.util.HashMap;

/**
 * linked list is given in which every node has two pointers,
 * one to its next node and the other one, random pointer,
 * pointing to some other node in the linked list.
 * You have to clone the given linked list. So*
 */
public class Test {
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
        node1.random = node5;

        node2.next = node3;
        node2.random = node1;

        node3.next = node4;
        node3.random = node4;

        node4.next = node5;

        node5.next = node6;
        node5.random = node1;

        node6.random = node4;

        Node  node = cloneLinkedListUtil(node1);
        printLinkedList(node);
    }

    private static void printLinkedList(Node node) {
        while(node != null){
            System.out.print(node.data + " ");
            System.out.print( node.random != null ? node.random.data : "");
            node = node.next;
            System.out.println();
        }
    }

    private static Node cloneLinkedListUtil(Node node1) {
        HashMap<Integer,Node> nodeIntegerHashMap = new HashMap<>();
        Node head  = cloneWithNextPointerLinkedList(node1,null,nodeIntegerHashMap);
        head = cloneWithRandomPointerLinkedList(head,node1,nodeIntegerHashMap);
        printLinkedList(head);
        return null;
    }

    private static Node cloneWithRandomPointerLinkedList(Node head, Node node1, HashMap<Integer, Node> nodeIntegerHashMap) {
        if(node1 == null)
            return null;
        Node randomOrig = node1.random;
        if(randomOrig != null)
            head.random = nodeIntegerHashMap.get(randomOrig.data);
        cloneWithRandomPointerLinkedList(head.next,node1.next,nodeIntegerHashMap);
        return head;
    }

    private static Node cloneWithNextPointerLinkedList(Node node1, Node prev,HashMap<Integer,Node> nodeIntegerHashMap) {
        if(node1 == null)
            return prev;
        Node node = new Node(node1.data);
        if(prev != null)
            prev.next = node;
        nodeIntegerHashMap.put(node.data,node);
        cloneWithNextPointerLinkedList(node1.next,node,nodeIntegerHashMap);
        return prev != null ? prev : node;
    }

    public static class Node {
        int data;
        Node next;
        Node random;

        public Node(int data) {
            this.data = data;
        }
    }


}

