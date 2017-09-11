package LinkedList;

/**
 * Created by TPathrikar on 9/11/2017.
 */
public class IsPalindrome {
    public static void main(String[] args) {
        Node head = new Node('t');
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('b');
        Node d = new Node('a');
        Node e = new Node('t');

        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println(isPalindrome(head));

    }

    private static boolean isPalindrome(Node head) {
        return recursiveUtil(head,head);
    }

    private static boolean recursiveUtil(Node left, Node right) {
        if(right == null)
            return true;
        boolean isPalindrome = recursiveUtil(left,right.next);
        if(!isPalindrome)
            return false;
        else if(right.next != null)
            left = left.next;
        isPalindrome = left.data == right.data;
        return isPalindrome;
        }


    }


 class Node{
    char data;
    Node next;

    public Node (char data){
        this.data = data;
    }
 }