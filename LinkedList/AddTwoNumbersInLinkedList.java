/*
* Add two numbers represented by linked list
* 5->6->7->9
* 7->4->3->2
* */


public class Demo {
    private static  int sum = 36;

    public static void main(String[] args) {
        CustomLinkedList in1 = new CustomLinkedList();
        CustomLinkedList in2 = new CustomLinkedList();

        CustomLinkedListNode a1 = new CustomLinkedListNode(5);
        CustomLinkedListNode a2 = new CustomLinkedListNode(6);
        CustomLinkedListNode a3 = new CustomLinkedListNode(7);
        CustomLinkedListNode a4 = new CustomLinkedListNode(9);

        CustomLinkedListNode b1 = new CustomLinkedListNode(7);
        CustomLinkedListNode b2 = new CustomLinkedListNode(4);
        CustomLinkedListNode b3 = new CustomLinkedListNode(3);
        CustomLinkedListNode b4 = new CustomLinkedListNode(2);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        b1.next = b2;
        b2.next = b3;
        b3.next = b4;

        in1.head = a1;
        in2.head = b1;
        a1 = reverseLinkedList(a1,null);
        b1 = reverseLinkedList(b1,null);
        CustomLinkedListNode out = addNumbers(a1,b1,null,null);
        printLinkedList(out);
    }
    private static void printLinkedList(CustomLinkedListNode linkedListNode) {
        while(linkedListNode !=null){
            System.out.print(linkedListNode.data + "->");
            linkedListNode = linkedListNode.next;
        }
    }

    private static CustomLinkedListNode addNumbers(CustomLinkedListNode a1, CustomLinkedListNode b1,CustomLinkedListNode prev,CustomLinkedListNode node) {
        int carry = 0;
        while (true){

            if(a1 == null || b1 == null) {
                node = prev;
                break;
            }
            int data;
            if(a1.data+b1.data+carry < 10) {
                data = a1.data + b1.data;
                carry = 0;
            }
            else {
                data = (a1.data + b1.data + carry) % 10;
                carry = 1;
            }
            CustomLinkedListNode temp1 = new CustomLinkedListNode(data);

            if(node == null)
                node = temp1;
            else {
                node = temp1;
                prev.next = temp1;
            }
                prev = temp1;
            a1 = a1.next;
            b1 = b1.next;

        }
        return node;
    }


    private static CustomLinkedListNode reverseLinkedList(CustomLinkedListNode node,CustomLinkedListNode prev) {
        CustomLinkedListNode temp;
        CustomLinkedList linkedList = new CustomLinkedList();
        while (true){
            if(node == null) {
                linkedList.head = prev;
                break;
            }
            temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }

        return linkedList.head;
    }

    private static class CustomLinkedList {
        CustomLinkedListNode head;
    }

    private static class CustomLinkedListNode {
        int data ;
        CustomLinkedListNode next;
        public CustomLinkedListNode(int i) {
            this.data = i;
        }
    }
}
