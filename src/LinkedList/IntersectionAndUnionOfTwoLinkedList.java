package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class IntersectionAndUnionOfTwoLinkedList {
    public static void main(String[] args) {
        Node a1 = new Node(10);
        Node a2 = new Node(15);
        Node a3 = new Node(4);
        Node a4 = new Node(20);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        Node b1 = new Node(8);
        Node b2 = new Node(4);
        Node b3 = new Node(2);
        Node b4 = new Node(10);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;

        printIntersectionAndUnion(a1, b1);

    }

    private static void printIntersectionAndUnion(Node a1, Node b1) {
        HashMap<Integer,Integer> map = new HashMap<>();
        while (a1 != null){
            map.put(a1.data,1);
            a1 = a1.next;
        }

        while (b1 != null){
            if(map.containsKey(b1.data)) {
                int count = map.get(b1.data);
                map.put(b1.data, count+1);
            }
            else
                map.put(b1.data,1);
            b1 = b1.next;
        }

        System.out.println("Intersection");
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if(integerIntegerEntry.getValue() > 1)
                System.out.print(integerIntegerEntry.getKey() + " ");
        }

        System.out.println("\nUnion");
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            System.out.print(integerIntegerEntry.getKey()+" ");
        }
    }

    private static int findLen(Node a1) {
        int len = 0;

        while (a1 != null ) {
            len++;
            a1 = a1.next;
        }
        return len;
    }


    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
