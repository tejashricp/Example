package Misc;

import java.util.HashMap;
import java.util.List;

/**
 * Created by TPathrikar on 8/31/2017.
 */
public class LRUCache {
    int capacity;
    HashMap<Integer,ListNode> hashMap = new HashMap<Integer, ListNode>();
    ListNode head;
    ListNode end;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key){
        if(hashMap.containsKey(key)){
            ListNode node = hashMap.get(key);
            setHead(node);
            return node.value;
        }
        return -1;
    }

    private void setHead(ListNode node) {
        if(head == null)
            head = node;
        else{
            ListNode temp = head;
            head = node;
            head.next = temp;
            temp.prev = head;
        }
    }

    public void set(int key,int value){
        if(hashMap.containsKey(key)){
            ListNode node = hashMap.get(key);
            node.value = value;
            setHead(node);
        }
        else {
            ListNode newNode = new ListNode(value);
            if(hashMap.size() >= capacity){
                removeEnd();
                setHead(newNode);
            }
            else
                setHead(newNode);
            hashMap.put(key,newNode);
        }
    }

    private void removeEnd() {
        ListNode prev = end.prev;
        prev.next = null;
        end = prev;
    }
}
 class ListNode {
    ListNode prev;
    ListNode next;
    int value;

     public ListNode(int value) {
         this.value = value;
     }
 }