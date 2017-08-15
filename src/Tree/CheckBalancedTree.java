/*
*
* check if given binary tree is balanced or not
*
* */


public class Demo {

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

        root.left = a1;
        root.right =a2;

        a1.left = a3;
        a1.right = a4;
        a4.right = a10;
        a2.right = a6;

        //a3.left = a7;
        //a3.right = a8;

        //a8.left = a9;

        //a10.left = a11;

        //a2.left = a5;

        System.out.println(isBalanced(root,0,0));

    }

    private static int isBalanced(TreeNode root, int leftCount, int rightCount) {
        if(root == null)
            return 0;
        if(leftCount ==  -1 || rightCount == -1)
            return -1;
        leftCount = isBalanced(root.left,leftCount,rightCount)+leftCount;
        rightCount = isBalanced(root.right,leftCount,rightCount)+rightCount;
        if(leftCount == 0 && rightCount == 0)
            return 1;
        if(Math.abs(leftCount-rightCount) <= 1 )
            return Math.max(leftCount,rightCount);
        return -1;
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
