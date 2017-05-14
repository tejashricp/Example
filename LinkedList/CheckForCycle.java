import java.util.HashMap;
import java.util.HashSet;

/**
 *Check if Linked list contains loop.
 */
public class Test {
    public static void main(String[] args) {
        Node head = new Node(1);
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

        head.next = node2;

        node2.next = node3;

        node3.next = node4;

        node4.next = node5;
        node5.next = node6;

        node6.next = node7;

        node7.next = node8;

        node8.next = node9;
        node9.next = node8;
        //node10.next = node11;

        System.out.println(checkIfHasCycleUsingVisitedFlag(head));
    }

    //using floyd's cycle finding mechanism
    private static boolean checkIfHasLoop(Node head) {
        Node p = head;
        Node q = head;
        while(p != null && q.next != null){
            p = p.next;
            q = q.next.next;
            if(p.data == q.data)
                return true;
        }
        return false;
    }

    private static boolean checkIfHasCycleUsingHadhTable(Node head){
        HashSet<Integer> integerHashSet = new HashSet<>();
        while(head != null){
            if(integerHashSet.contains(head.data))
                return true;
            else
                integerHashSet.add(head.data);
            head = head.next;
        }
        return false;
    }

    private static boolean checkIfHasCycleUsingVisitedFlag(Node head){
        while(head != null){

            if(head.visited)
                return true;
            else
                head.visited = true;

            head = head.next;
        }
        return false;
    }

    public static class Node {
        int data;
        Node next;
        boolean visited;

        public Node(int data) {
            this.data = data;
        }
    }


}

