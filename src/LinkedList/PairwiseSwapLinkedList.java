package LinkedList;/*
*
* Given a singly linked list, write a function to swap elements pairwise.
* For example, if the linked list is 1->2->3->4->5
* then the function should change it to 2->1->4->3->5,
* and if the linked list is 1->2->3->4->5->6
* then the function should change it to 2->1->4->3->6->5.
*
* */


public class PairwiseSwapLinkedList {
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
        swapLinkedListPairwise(linkedList);
        printLinkedList(linkedList.head);

    }

    private static void printLinkedList(CustomLinkedListNode node) {
        while(node != null){
            System.out.print(node.data+" ");
            node = node.next;
        }
    }

    private static void swapLinkedListPairwise(CustomLinkedList list) {
        CustomLinkedListNode p =null,q=null,p_prev = null, q_next=null;
        p = list.head;
        while(true){
         if(p == null )
             break;
         q = p.next;

         if(q != null) {
             q_next = q.next;
             q.next = p;
         }
         else
             break;
         if(p_prev != null)
             p_prev.next = q;
         else
             list.head = q;
         p.next = q_next;
         
         p_prev = p;
         p = p.next;
        }

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

