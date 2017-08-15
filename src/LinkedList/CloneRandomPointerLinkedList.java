package LinkedList;/*
*  A linked list is given in which every node has two pointers,
*  one to its next node and the other one, random pointer,
*  pointing to some other node in the linked list.
*  You have to clone the given linked list.
* */


import java.util.HashMap;
import java.util.Map;

public class CloneRandomPointerLinkedList {
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
        listNode1.random = listNode5;

        listNode2.next = listNode3;
        listNode2.random = listNode1;

        listNode3.next = listNode4;
        listNode3.random = listNode4;

        listNode4.next = listNode5;
        listNode4.random = listNode1;

        listNode5.next = listNode6;
        listNode5.random = listNode6;

        listNode6.next = null;
        listNode6.random = listNode5;

        linkedList = cloneLinkedList(linkedList.head,null,linkedList.head.random);
        printLinkedList(linkedList.head);

    }

    private static void printLinkedList(CustomLinkedListNode linkedListNode) {
        while(linkedListNode !=null){
            System.out.print(linkedListNode.data + "->"+(linkedListNode.random == null ? "":linkedListNode.random.data) );
            System.out.println();
            linkedListNode = linkedListNode.next;
        }
    }

    private static CustomLinkedList cloneLinkedList(CustomLinkedListNode node, CustomLinkedListNode prev, CustomLinkedListNode random) {

        CustomLinkedList customLinkedList = getCloneSimpleLinkedList(node, prev);

            return customLinkedList;
        }


    private static CustomLinkedList getCloneSimpleLinkedList(CustomLinkedListNode node, CustomLinkedListNode prev) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        HashMap<CustomLinkedListNode,Integer> node_randomMap = new HashMap<CustomLinkedListNode, Integer>();
        HashMap <Integer,CustomLinkedListNode> val_nodeMap = new HashMap<Integer, CustomLinkedListNode>();
        while(node != null){
            if(node.random !=null)
                node_randomMap.put(node,node.random.data);
            val_nodeMap.put(node.data,node);
            if(customLinkedList.head == null){
                customLinkedList.head = node;
            }
            else
                prev.next = node;
            if(node.random != null && val_nodeMap.containsKey(node.random.data)) {
                node.random = val_nodeMap.get(node.random.data);
                node_randomMap.remove(node);
            }
            prev = node;
            node = node.next;
        }
        for (Map.Entry<CustomLinkedListNode, Integer> listNode : node_randomMap.entrySet()) {
           listNode.getKey().random = val_nodeMap.get(listNode.getKey().random.data);
        }
        return customLinkedList;
    }

    private static class CustomLinkedList {
        CustomLinkedListNode head;
    }

    private static class CustomLinkedListNode {
        int data ;
        CustomLinkedListNode next;
        CustomLinkedListNode random;
        public CustomLinkedListNode(int i) {
            this.data = i;
        }
    }
}
