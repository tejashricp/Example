package Tree;/*
*
* Mirror of a Tree: Mirror of a Binary 
* Tree T is another Binary Tree M(T) with left and 
* right children of all non-leaf nodes interchanged.
*
* */


public class MirrorImage {

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

        a1.left = a3;
        a1.right = a4;


        a2.left = a5;
        a2.right = a6;

        makeMirrorTree(root);
        inOrder(root);
    }

    private static void inOrder(TreeNode root) {
        if(root == null)
            return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    private static void makeMirrorTree(TreeNode root) {
        if(root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right  =temp;
        makeMirrorTree(root.left);
        makeMirrorTree(root.right);

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
