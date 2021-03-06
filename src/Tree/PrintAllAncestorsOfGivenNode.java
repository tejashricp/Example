package Tree;

import java.util.Stack;

/**
 * Created by TPathrikar on 8/3/2017.
 Given a Binary Tree and a key, write a function that prints all the ancestors of the key in the given binary tree.

 For example, if the given tree is following Binary Tree and key is 7, then your function should print 4, 2 and 1.
        1
      /   \
     2      3
    /  \
   4   5
  /
 7


 *
 * */

public class PrintAllAncestorsOfGivenNode {

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
        //boundaryTraverse(root);
        printAllAncestors(root,9);
    }
    private static boolean printAllAncestors(TreeNode root,int key) {
        if(root == null)
            return false;
        if(root.data == key)
            return true;
        if(printAllAncestors(root.left,key) || printAllAncestors(root.right,key)) {
            System.out.print(root.data+" ");
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

}
