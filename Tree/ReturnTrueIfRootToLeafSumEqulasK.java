/*
*  Given a binary tree and a number,
*  return true if the tree has a root-to-leaf path such that
*  adding up all the values along the path equals the given number.
* */


public class Demo {
    private static  int sum = 36;

    public static void main(String[] args) {
        TreeNode root =  new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(5);
        TreeNode a3 = new TreeNode(8);
        TreeNode a4 = new TreeNode(18);
        TreeNode a5 = new TreeNode(6);
        TreeNode a6 = new TreeNode(3);
        TreeNode a7 = new TreeNode(2);
        TreeNode a8 = new TreeNode(12);
        TreeNode a9 = new TreeNode(1);
        TreeNode a10 = new TreeNode(11);

        root.left = a1;
        root.right =a2;

        a1.left = a3;
        a1.right = a4;

        a4.left = a6;

        a2.right = a5;
        a6.right = a7;

        a5.left = a8;
        a8.right = a9;
        a9.left = a10;

        CustomLinkedList linkedList = new CustomLinkedList();
        CustomLinkedListNode head = new CustomLinkedListNode(root.data);

        System.out.println(hasRootToLeafSum(root,0,head));
        printLinkedList(head);
    }

    private static void printLinkedList(CustomLinkedListNode linkedListNode) {
        while(linkedListNode !=null){
            System.out.print(linkedListNode.data + "->");
            linkedListNode = linkedListNode.next;
        }
    }
    private static boolean hasRootToLeafSum(TreeNode root, int current, CustomLinkedListNode head) {
        if(root == null && current == sum)
            return true;
        else if(root == null)
            return false;
        current = current+root.data;
        head.next = new CustomLinkedListNode(root.data);
        head = head.next;
        if (hasRootToLeafSum(root.left,current, head)) {
            return true;
        }
        if(hasRootToLeafSum(root.right,current, head)) {
            return true;
        }
        return false;
    }

    public static class TreeNode {
        int data;
        TreeNode left ;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
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
