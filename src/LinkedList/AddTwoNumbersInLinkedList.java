package LinkedList;/*
* Add two numbers represented by linked list
* 5->6->7->9
* 7->4->3->2
* */


public class AddTwoNumbersInLinkedList {
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
        //working solution without reversing linked list
        appendZeroForSmallerList(in1,in2,4,3);
        out = addTwoNumbers(in1.head, in2.head);
        printLinkedList(out);
        
    }
   // approach : appending zero in front for smaller linked list 
    private static void appendZeroForSmallerList(CustomLinkedList in1, CustomLinkedList in2, int len1, int len2) {
        int count  = 0;
        while(len1>len2 && count != len1-len2){
        CustomLinkedListNode zero = new CustomLinkedListNode(0);
        zero.next = in2.head;
        in2.head = zero;
        count++;
        }
        while(len2>len1 && count != len2-len1){
            CustomLinkedListNode zero = new CustomLinkedListNode(0);
            zero.next = in1.head;
            in1.head = zero;
            count++;
        }

    }

    private static CustomLinkedListNode addTwoNumbers(CustomLinkedListNode a1, CustomLinkedListNode b1) {
        if(a1 == null && b1 == null)
            return null;
        CustomLinkedListNode nextNode = addTwoNumbers(a1.next,b1.next);
        CustomLinkedListNode node;
        int carry = 0;
        if(nextNode != null ) {
            carry = (nextNode.data) / 10;
            nextNode.data =  (nextNode.data) % 10;
        }
        node= new CustomLinkedListNode(a1.data+b1.data+carry);
        node.next = nextNode;
        return node;
    }
    
    //approach end : appending zero at the front
    
    
    //approach : without changing length of linked list
    private static CustomLinkedListNode addTwoNumbers(CustomLinkedListNode a1, CustomLinkedListNode b1,int len1,int len2,int count) {
        CustomLinkedListNode answer = null;
        if(len1 > len2){
            CustomLinkedListNode tempA1 = getNodeOfEqualSize(a1,len1,len2);
            CustomLinkedListNode answerForEqualLen = getSumForEqualSize(tempA1,b1);
            answer = addCarryToRemaingNodes(len1-len2,a1,answerForEqualLen,0);

        }
        else if(len2>len1){
            CustomLinkedListNode tempB1 = getNodeOfEqualSize(b1,len2,len1);
            answer = getSumForEqualSize(tempB1,b1);
            answer = addCarryToRemaingNodes(len2-len1,b1,answer,0);
        }
        if(len1 == len2){
            answer = getSumForEqualSize(a1,b1);
        }
        if(answer.data >= 10){
            CustomLinkedListNode lastNode = new CustomLinkedListNode(answer.data/10);
            answer.data = answer.data%10;
            lastNode.next = answer;
            answer = lastNode;
        }
        return answer;
}

    private static CustomLinkedListNode getNodeOfEqualSize(CustomLinkedListNode a1, int len1, int len2) {
        return null;
    }

    private static CustomLinkedListNode addCarryToRemaingNodes(int diff, CustomLinkedListNode a1, CustomLinkedListNode pervAnswer,int count) {
        if(diff == count)
            return null;
        CustomLinkedListNode node = addCarryToRemaingNodes(diff,a1.next,pervAnswer,count+1);
        int carry = 0;
        if(node == null) {
            carry = pervAnswer.data / 10;
            pervAnswer.data = pervAnswer.data%10;
        }
        else{
            carry = node.data/10;
        }
        CustomLinkedListNode result  = new CustomLinkedListNode(a1.data+carry);
        if(node == null)
            result.next = pervAnswer;
        else
            result.next = node;
        return result;
    }

    private static CustomLinkedListNode getSumForEqualSize(CustomLinkedListNode a1, CustomLinkedListNode b1) {
        if(a1 == null && b1 == null){
            return null;
        }
        CustomLinkedListNode nextNode  = getSumForEqualSize(a1.next,b1.next);
        int carry = 0;
        if(nextNode!=null) {
            carry = nextNode.data/10;
            nextNode.data = nextNode.data%10;
        }
        CustomLinkedListNode node  = new CustomLinkedListNode(a1.data+b1.data+carry);
        node.next = nextNode;
        return node;
    }
    //approach end : without changing length of linked list
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
