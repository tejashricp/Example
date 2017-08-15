package Tree;

/**
 * Created by TPathrikar on 5/3/2017.
 * Check if given tree is symmetric
 *         1
 *       /   \
 *      2     2
 *    /  \   /  \
 *   4    3 3    4

 */
public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode root =  new TreeNode(0);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(3);
        TreeNode a5 = new TreeNode(3);
        TreeNode a6 = new TreeNode(4);
        /*TreeNode a7 = new TreeNode(7);
        TreeNode a8= new TreeNode(8);
        TreeNode a9 = new TreeNode(9);
        TreeNode a10 = new TreeNode(10);
        TreeNode a11= new TreeNode(11);*/

        root.left = a1;
        root.right =a2;

        a1.left = a3;
        //a1.right = a4;
        //a4.right = a10;
        //a2.right = a6;
         a2.right = a5;
        //a3.left = a7;
        //a3.right = a8;

        //a8.left = a9;

        //a10.left = a11;

        //a2.left = a5;

        System.out.println(isSymmetric(root,root));

    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
    if(left == null && right == null)
        return true;
    if(left == null && right != null)
        return false;
    if(right == null && left != null)
        return false;

        if(left.data == right.data&&
        isSymmetric(left.left,right.right)&&
        isSymmetric(left.right,right.left))
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

