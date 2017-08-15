package LinkedList;/*
*  Given a Singly Linked List, write a function to delete a given node. Your function must follow following constraints:
*1) It must accept pointer to the start node as first parameter and node to be deleted as second parameter i.e., pointer to head node is not global.
*2) It should not return pointer to the head node.
*3) It should not accept pointer to pointer to head node.
* */


public class DeleteNode {
    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();

        CustomLinkedListNode listNode1 = new CustomLinkedListNode(1);
        CustomLinkedListNode listNode2 = new CustomLinkedListNode(2);
        CustomLinkedListNode listNode3 = new CustomLinkedListNode(3);
        CustomLinkedListNode listNode4 = new CustomLinkedListNode(4);
        CustomLinkedListNode listNode5 = new CustomLinkedListNode(5);
        CustomLinkedListNode listNode6 = new CustomLinkedListNode(6);
        CustomLinkedListNode listNode7 = new CustomLinkedListNode(7);
        linkedList.head = listNode1;

        listNode1.next = listNode2;

        listNode2.next = listNode3;

        listNode3.next = listNode4;

        listNode4.next = listNode5;

        listNode5.next = listNode6;

        listNode6.next = null;

        deleteNode(linkedList.head,listNode1);
        printLinkedList(linkedList.head);
    }

    private static void printLinkedList(CustomLinkedListNode head) {
        while(head!=null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    private static void deleteNode(CustomLinkedListNode head, CustomLinkedListNode listNode) {
        CustomLinkedListNode nextNode;
        CustomLinkedListNode prevNode;
        if(head == listNode){
            if(head.next == null){
                System.out.println("Cant delete. As this linked list contains only one node");
                return;
            }
            else {
                nextNode = head.next;
                head = nextNode;
                return;
            }
        }
        prevNode = head;
        nextNode = head.next;
        while (nextNode != null){
            if(nextNode == listNode){
                if(nextNode.next != null){
                    prevNode.next = nextNode.next;
                }
                return;
            }
            prevNode = nextNode;
            nextNode = nextNode.next;

        }
        System.out.println("Node is not present in linked list");
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

