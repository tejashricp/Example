package Tree;/*
*Given a binary tree with a random pointer in every node, we have to create a 
* duplicate of input binary tree. Below is the structure of binary tree node with random pointer.

struct node {
    int data;
    struct node *left;
    struct node *right;
    struct node *random;
};
The random pointer of a node can point to any node of tree or can even point to NULL. 
In this program, we will use a map of node pointers. While cloning binary tree, we will populate 
the address of original tree node and corresponding node in duplicate tree so that we will have a one 
to one mapping between old and corresponding new nodes.
* */

import java.util.HashMap;
import java.util.Map;

public class CloneABinaryTreeWithRandomPointer {

    public static Map<TreeNode,TreeNode> cloneTreeNodeMap = new HashMap<TreeNode, TreeNode>();
    public static void main(String[] args) {
        TreeNode root =  new TreeNode(0);
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);

        root.left = a1;
        root.right =a2;
        root.random = a5;

        a1.left = a3;
        a1.right = a4;
        a1.random = a2;

        a4.random = root;

        a2.left = a5;
        a2.random = root;

        TreeNode newRootNode = createCloneNode(root);
        createRandomNode(root,newRootNode);
        traverseTree(newRootNode);
    }

    private static void traverseTree(TreeNode newRootNode) {
        if(newRootNode == null)
            return;
        System.out.println(newRootNode.data);
        traverseTree(newRootNode.left);
        traverseTree(newRootNode.right);

    }

    public static class TreeNode {
        int data;
        TreeNode left ;
        TreeNode right;
        TreeNode random;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static TreeNode createCloneNode(TreeNode root){
        if(root == null)
            return null;
        TreeNode newNode = new TreeNode(root.data);
        cloneTreeNodeMap.put(root,newNode);
        newNode.left =  createCloneNode(root.left);
        newNode.right = createCloneNode(root.right);
        return newNode;
    }

    public static void createRandomNode(TreeNode root,TreeNode newNode){
        if(newNode == null)
            return ;
        newNode.random = cloneTreeNodeMap.get(root.random);
        createRandomNode(root.left,newNode.left);
        createRandomNode(root.right,newNode.right);
    }


}
