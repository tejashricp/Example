package Tree;

import java.util.HashMap;
import java.util.HashSet;

/**
 *Create Balanced binary search tree from sorted array
 */
public class SortedArrayToBalancedBinaryTree {
    public static void main(String[] args) {
        int[] arr = {4,6,32,54,57,67,80};
        Node root = createBalancedBinaryTree(arr,0,arr.length-1);
        traverseInorder(root);
    }

    private static void traverseInorder(Node root) {
        if (root == null)
            return;
        traverseInorder(root.left);
        System.out.print(root.data +" ");
        traverseInorder(root.right);
    }

    private static Node createBalancedBinaryTree(int[] input,int start,int end) {
        if(start > end)
            return null;
        Node root = null;
        int mid = (start+end)/2;
        root = new Node(input[mid]);
        root.left = createBalancedBinaryTree(input,start,mid-1);
        root.right = createBalancedBinaryTree(input,mid+1,end);
        return root;
    }


    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}

