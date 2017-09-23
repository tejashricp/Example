package LinkedList;

import java.util.Stack;

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

        System.out.println(isPalindromeRecursive(head,head));

    }

    private static boolean isPalindrome(Node head) {
    Stack<Node> stack = new Stack();
    Node nextTonext = head;
    while (nextTonext != null  ){
        if(nextTonext.next == null) {
            head = head.next;
            break;
        }
        stack.push(head);
        head = head.next;
        nextTonext = nextTonext.next.next;
    }
    while (head != null){
        Node temp = stack.pop();
        if(head.data != temp.data)
            return false;
        head = head.next;
    }
    return true;
    }

    public static boolean isPalindromeRecursive(Node left , Node right){
        if(right == null )
            return true;
        Node temp = left.next;
        if(right.next == null && left.data == right.data)
            return true;
        else if(isPalindromeRecursive(left,right.next.next))
            return temp.data == right.data;

        return false;
    }

}


 class Node{
    char data;
    Node next;

    public Node (char data){
        this.data = data;
    }
 }