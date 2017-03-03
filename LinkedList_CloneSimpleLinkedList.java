
/*
* Clone a linked list
*
* * */

public class Demo {
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
        cloneLinkedList(linkedList.head,null);

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
