package LinkedList;/*
* Clone a linked list
*
* and reverse a linked list
* */

public class CloneSimpleLinkedList {
    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();

        CustomLinkedListNode listNode1 = new CustomLinkedListNode(1);
        CustomLinkedListNode listNode2 = new CustomLinkedListNode(2);
        CustomLinkedListNode listNode3 = new CustomLinkedListNode(3);
        CustomLinkedListNode listNode4 = new CustomLinkedListNode(4);
        CustomLinkedListNode listNode5 = new CustomLinkedListNode(5);
        CustomLinkedListNode listNode6 = new CustomLinkedListNode(6);
        linkedList.head = listNode1;

        listNode1.next = listNode2;

        listNode2.next = listNode3;

        listNode3.next = listNode4;

        listNode4.next = listNode5;

        listNode5.next = listNode6;

        listNode6.next = null;
        linkedList = cloneLinkedList(linkedList.head,null);
        printLinkedList(linkedList.head);
        System.out.println();
        linkedList = reverseLinkedList(linkedList.head,null);
        printLinkedList(linkedList.head);
    }

    private static CustomLinkedList reverseLinkedList(CustomLinkedListNode node, CustomLinkedListNode prev) {
        CustomLinkedList reverseLinkedList = new CustomLinkedList();
        CustomLinkedListNode temp;
        while(true){
            if(node == null){
               reverseLinkedList.head = prev;
                break;
            }
            else {
                temp = node.next;
                node.next = prev;
                prev = node;
                node = temp;
            }
        }

        return reverseLinkedList;
    }

    private static void printLinkedList(CustomLinkedListNode linkedListNode) {
        while(linkedListNode !=null){
            System.out.print(linkedListNode.data + "->");
            linkedListNode = linkedListNode.next;
        }
    }

    private static CustomLinkedList cloneLinkedList(CustomLinkedListNode node, CustomLinkedListNode prev) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        while(node != null){
            if(customLinkedList.head == null){
                customLinkedList.head = node;
            }
            else
                prev.next = node;
            prev = node;
            node = node.next;
        }


        return customLinkedList;
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
