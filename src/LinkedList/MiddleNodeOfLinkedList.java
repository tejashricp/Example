package LinkedList;/*
* Given a singly linked list, find middle of the linked list.
* For example, if given linked list is 1->2->3->4->5 then output should be 3.
* If there are even nodes, then there would be two middle nodes,
* we need to print second middle element.
* For example, if given linked list is 1->2->3->4->5->6 then output should be 4.
* */


public class MiddleNodeOfLinkedList {
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

        listNode5.next = null;

        listNode6.next = null;
        printMiddleNodeOfLinkedList(linkedList);
    }

    private static void printMiddleNodeOfLinkedList(CustomLinkedList linkedList) {
        CustomLinkedListNode nextPointer = linkedList.head;
        CustomLinkedListNode nextToNextPointer = linkedList.head;
        while(true){
            if(nextToNextPointer == null || nextPointer.next == null)
                break;
            if(nextToNextPointer.next != null) {
                    nextToNextPointer = nextToNextPointer.next.next;
                    nextPointer = nextPointer.next;
            }
            else
                break;
        }
        System.out.println(nextPointer.data);
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
