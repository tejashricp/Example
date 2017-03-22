/*
*Given a binary tree, print the left and right view of this binary tree using two tree traversals.
* */

/*
*  Left and right view of a tree traversal
* */



import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        TreeNode root =  new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(4);
        TreeNode a4 = new TreeNode(5);
        TreeNode a5 = new TreeNode(6);
        TreeNode a6 = new TreeNode(7);
        TreeNode a7 = new TreeNode(8);

        root.left = a1;
        root.right =a2;

        a1.left = a3;
        a1.right = a4;


        a2.left = a5;
        a2.right = a6;

        a4.left = a7;
        Queue<TreeNode> treeNodeQueueRead = new LinkedList<>();
        Queue<TreeNode> treeNodeQueueCopy = new LinkedList<>();
        treeNodeQueueRead.add(root);
        leftViewTraverse(treeNodeQueueCopy,treeNodeQueueRead);
        System.out.println("===================");
        treeNodeQueueCopy.clear();
        treeNodeQueueRead.clear();
        treeNodeQueueRead.add(root);
        rightViewTraverse(treeNodeQueueCopy,treeNodeQueueRead);
        System.out.println("===================");
        treeNodeQueueRead.clear();
        treeNodeQueueRead.add(root);
        rightViewTraverse(treeNodeQueueRead);
        System.out.println("===================");
        treeNodeQueueRead.clear();
        treeNodeQueueRead.add(root);
        leftViewTraverse(treeNodeQueueRead);

    }

    
    private static void leftViewTraverse(Queue<TreeNode> treeNodeQueueRead) {
            if(treeNodeQueueRead.isEmpty())
                return;
            TreeNode root = treeNodeQueueRead.poll();
            if(root.right != null) {
                root.right.level = root.level+1;
                treeNodeQueueRead.add(root.right);
            }
            if(root.left != null) {
                root.left.level = root.level+1;
                treeNodeQueueRead.add(root.left);
            }
            if(treeNodeQueueRead.isEmpty() || root.level != treeNodeQueueRead.peek().level) {
                System.out.print(root.data+" ");
                System.out.println();
            }
        leftViewTraverse(treeNodeQueueRead);
    }

    private static void rightViewTraverse(Queue<TreeNode> treeNodeQueueRead) {
        if(treeNodeQueueRead.isEmpty())
            return;
        TreeNode root = treeNodeQueueRead.poll();
        if(root.left != null) {
            root.left.level = root.level+1;
            treeNodeQueueRead.add(root.left);
        }
        if(root.right != null) {
            root.right.level = root.level+1;
            treeNodeQueueRead.add(root.right);
        }
        if(treeNodeQueueRead.isEmpty() || root.level != treeNodeQueueRead.peek().level) {
            System.out.print(root.data+" ");
            System.out.println();
        }
        rightViewTraverse(treeNodeQueueRead);
    }
    
    private static void leftViewTraverse(Queue<TreeNode> treeNodeQueueCopy, Queue<TreeNode> treeNodeQueueRead) {
            if(treeNodeQueueRead.isEmpty()) 
                return;
            TreeNode root = treeNodeQueueRead.poll();
            if(root.right != null)
                treeNodeQueueCopy.add(root.right);
            if(root.left != null)
                treeNodeQueueCopy.add(root.left);
            if(treeNodeQueueRead.isEmpty()) {
                System.out.print(root.data+" ");
                while (!treeNodeQueueCopy.isEmpty())
                    treeNodeQueueRead.add(treeNodeQueueCopy.poll());
                System.out.println();
            }
        leftViewTraverse(treeNodeQueueCopy,treeNodeQueueRead);
    }

    private static void rightViewTraverse(Queue<TreeNode> treeNodeQueueCopy, Queue<TreeNode> treeNodeQueueRead) {
        if(treeNodeQueueRead.isEmpty()) {
            return;
        }
        TreeNode root = treeNodeQueueRead.poll();
        if(root.left != null)
            treeNodeQueueCopy.add(root.left);
        if(root.right != null)
            treeNodeQueueCopy.add(root.right);
        if(treeNodeQueueRead.isEmpty()) {
            System.out.print(root.data+" ");
            while (!treeNodeQueueCopy.isEmpty())
                treeNodeQueueRead.add(treeNodeQueueCopy.poll());
            System.out.println();
        }
        rightViewTraverse(treeNodeQueueCopy,treeNodeQueueRead);
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
