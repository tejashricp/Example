package LinkedList;

public class MergeTwoSortedLinkedList {

    public static void main(String[] args) {

        Node a1 = new Node(2);
        Node a2 = new Node(5);
        Node a3 = new Node(12);
        Node a4 = new Node(34);
        Node a5 = new Node(78);
        Node a6 = new Node(123);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;

        Node b1 = new Node(2);
        Node b2 = new Node(7);
        Node b3 = new Node(33);
        Node b4 = new Node(54);
        Node b5 = new Node(90);
        Node b6 = new Node(98);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;
        b5.next = b6;
        Node head = mergeTwoLinkedLists(a1, b1);
        printSolution(head);

    }

    private static Node mergeTwoLinkedLists(Node a1, Node b1) {
        Node p = a1;
        Node q = b1;
        Node r = null;
        Node head = null;
        while (q != null) {
            if (p.next == null) {
                if (p.data < q.data) {
                    p.next = q;
                    break;
                }
            }


            if (p.data >= q.data) {
                if (head == null) {
                    head = q;
                }
                Node temp = q;
                Node nextTemp = temp.next;
                q.next = p;
                if (r != null)
                    r.next = q;
                r = q;
                q = nextTemp;
            } else {
                if (head == null)
                    head = p;
                Node temp = p;
                r = p;
                p = temp.next;
            }

        }
        return head;
    }

    private static void printSolution(Node head) {
        do {
            System.out.print(head.data + " ");
            head = head.next;
        }while (head != null);

    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
