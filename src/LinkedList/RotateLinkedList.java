/**
 * Created by TPathrikar on 8/3/2017.
 Given a singly linked list, rotate the linked list counter-clockwise by k nodes. Where k is a given positive integer.
 For example,
 if the given linked list is 10->20->30->40->50->60 and k is 4,
 the list should be modified to 50->60->10->20->30->40.
 Assume that k is smaller than the count of nodes in linked list.

 *
 * */

public class Test1 {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);
        Node node5 = new Node(50);
        Node node6 = new Node(60);

        head.next = node2;
        //50->60->10->20->30->40
        node2.next = node3;

        node3.next = node4;

        node4.next = node5;
        node5.next = node6;

        int k = 3;
        //if k is greater than linked list size, first calculate size and then do k=k%size
        Node node = rotateLinkedListClockwise(head,k);
        while (node != null){
            System.out.print(node.data +" ");
            node = node.next;
        }
    }

    private static Node rotateLinkedListAntiClockwise(Node head, int k) {
        Node newHead = null;
        Node oldHead  = head;
        int cnt = 1;
        Node prev  = null;
        while (true){
            //10 20 30 40 50 60
            if(head == null)
                break;
            if(cnt > k && newHead == null) {
                prev.next = null;
                newHead = head;
            }
            prev = head;
            head = head.next;
            cnt++;
        }
        prev.next = oldHead;
        return newHead;
    }

    private static Node rotateLinkedListClockwise(Node head, int k) {
        Node newHead = null;
        Node oldHead  = head;
        int cnt = 1;
        Node prev  = null;
        Node temp = null;
        while (head != null){
            //10 20 30 40 50 60
            //30 40 50 60 10 20
            if(cnt > k && newHead == null) {
                temp = oldHead;
            }
            prev = head;
            head = head.next;
            if(temp != null)
                temp = temp.next;
            cnt++;
        }
        newHead = temp.next;
        temp.next = null;
        prev.next = oldHead;
        return newHead;
    }

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }



}
