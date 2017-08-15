package Tree;

/**
 * Created by TPathrikar on 8/3/2017.
 Write a function that returns true if the given Binary Tree is SumTree else false. A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree and right subtree. An empty tree is SumTree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.

 Following is an example of SumTree.

     26
    /   \
   10     3
 /    \    \
 4      6   3


 *
 * */

public class IsSumTree {

    public static void main(String[] args) {
        TreeNode root =  new TreeNode(26);
        TreeNode a1 = new TreeNode(10);
        TreeNode a2 = new TreeNode(3);

        TreeNode a3 = new TreeNode(4);
        TreeNode a4 = new TreeNode(6);

        TreeNode a5 = new TreeNode(3);

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
        a2.left = a5;

        /*a3.left = a7;
        a3.right = a8;

        a4.right = a10;
        a6.right = a12;
        a8.left = a9;

        a10.left = a11;
*/
        //a2.left = a5;
        //boundaryTraverse(root);
        System.out.println(isSumTree(root));
    }
    private static boolean isSumTree(TreeNode root) {
        if(root == null || (root.left ==null && root.right == null))
            return true;
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
            if(root.data == leftSum+rightSum && isSumTree(root.left)&& isSumTree(root.right))
                return true;
            return false;
    }

    private static int sum(TreeNode root) {
        if(root == null)
            return 0;
        return sum(root.left)+root.data+sum(root.right);
    }

 private static boolean isSumTreeApp2(TreeNode root) {
        if(root == null || isLeaf(root))
            return true;

        int leftSum = isLeaf(root.left) && root.left != null ?root.left.data: (root.left == null ? 0 :root.left.data*2);
        int rightSum = isLeaf(root.right) && root.right != null?root.right.data:(root.right == null ? 0 :root.right.data*2);
        if(root.data == leftSum+rightSum && isSumTreeApp2(root.left)&& isSumTreeApp2(root.right))
            return true;
        return false;
    }
 private static boolean isLeaf(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return true;

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
