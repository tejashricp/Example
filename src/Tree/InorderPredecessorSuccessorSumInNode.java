package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 Given a binary tree
 replace each node with sum of its predecessor and successor of that node
 array based approach space o(n) and time o(n)
 keep complete inorder raversal in an array and then calculate result for current 
 node from array roo.data = arr[i-1]+arr[i+1];
 */
public class InorderPredecessorSuccessorSumInNode{

    public static void main(String[] args) {
        TreeNode root =  new TreeNode(0);
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);

        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);
        TreeNode a7 = new TreeNode(7);
        TreeNode a8= new TreeNode(8);
        TreeNode a9 = new TreeNode(9);
        TreeNode a10 = new TreeNode(10);
        TreeNode a11= new TreeNode(11);
        TreeNode a12 = new TreeNode(12);
        root.left = a1;
        root.right =a2;     //     0
        //    / \
        //   1        2
        //  / \      / \
        // 3    4   5   6
        a1.left = a3;    //   /\     \       \
        a1.right = a4;   //  7  8    10       12
        //     /     /
        //    9     11
        a2.right = a6;
        a2.left = a5;

        a3.left = a7;
        a3.right = a8;

        a4.right = a10;
        a6.right = a12;
        a8.left = a9;

        a10.left = a11;

        //a2.left = a5;
        List<Integer> arr= new ArrayList();
        printInorder(root);
        inorder(root,arr);
        System.out.println();
        i=0;
        modifyTree(root,arr);
        printInorder(root);
    }

    private static void modifyTree(TreeNode root, List<Integer> arr) {
        if(root == null)
            return;
        modifyTree(root.left,arr);
        if(i == 0)
            root.data = 0+arr.get(i+1);
        else if(i == arr.size()-1)
            root.data = arr.get(i-1)+0;
        else
            root.data = arr.get(i-1)+arr.get(i+1);
        i = i+1;
        modifyTree(root.right,arr);
    }
    private  static int i=0;
    private static void inorder(TreeNode root,List arr) {
        if(root ==null)
            return;
        inorder(root.left,arr);
        ++i;
        arr.add(root.data);
        inorder(root.right,arr);
    }

    private static void printInorder(TreeNode root) {
        if(root ==null)
            return;
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }

    public static class TreeNode {
        int data;
        TreeNode left ;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }
}


