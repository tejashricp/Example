package Tree;

/**
 *Given binary tree, sum all the numbers starting from root to leaf node
 *      1
 *     / \
 *    2   3
 *   /\    \
 *  4  5    6
 *  sum = 124+125+136=385

 * */
public class SumOfRootToleafNumbers {
    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(6);
        TreeNode a2 = new TreeNode(3);

        TreeNode a3 = new TreeNode(5);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(2);
        TreeNode a6 = new TreeNode(5);
        TreeNode a7 = new TreeNode(4);
        TreeNode a8 = new TreeNode(7);
        a1.left = a2;    //   /\     \       \
        a1.right = a3;   //  7  8    10       12

        a2.right = a6;
        a2.left = a5;

        a3.right = a7;

        a6.left = a8;
        a6.right = a4;

        int sum  = sumAllNumbers(a1,0);
        System.out.println(sum);

    }

    private static int sumAllNumbers(TreeNode node,int number) {
        if(node == null)
            return 0;
        number = (number*10)+node.data;
        if(node.left == null && node.right == null)
            return number;
        return sumAllNumbers(node.left,number)
        + sumAllNumbers(node.right,number);
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
