/*
*Given a binary tree, print the left and right view of this binary tree.
* */

public class Demo {
    public static int count = 1;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);

        root.left = a1;
        root.right = a2;

        a1.left = a3;
        a1.right = a4;

        a2.left = a5;
        a3.left = a6;

        printAllEdgeNodes(root);

    }

    private static void printAllEdgeNodes(TreeNode root) {
        printAllLeftEdges(root);
        printAllRightEdges(root);

    }

    private static void printAllRightEdges(TreeNode root) {
        if(root == null)
            return;
        System.out.println(root.data);
        printAllRightEdges(root.right);
    }

    private static void printAllLeftEdges(TreeNode root) {
        if(root == null)
            return;
        System.out.println(root.data);
        printAllLeftEdges(root.left);

    }


}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}
