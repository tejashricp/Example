/*
*
Diameter of binary tree
* */


public class Demo {
    public static int diameter = 0;


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
        root.right =a2;

        a1.left = a3;
        a1.right = a4;

        a4.right = a5;
        a4.left = a6;

        a2.right = a7;

        a7.right = a8;

        a8.left = a9;
        a8.right = a10;

        a9.left = a11;
        a9.right = a12;
        //a3.left = a7;
        //a3.right = a8;

        //a8.left = a9;

        //a10.left = a11;

        //a2.left = a5;

        int count = 0;
        findDiameter(root,count);
        System.out.println(diameter);

    }

    private static int findDiameter(TreeNode root, int count) {
        if(root == null)
            return count;
        int leftCount = findDiameter(root.left,count);
        int rightCount = findDiameter(root.right,count);
        count = Math.max(leftCount+1,rightCount+1);
        diameter = Math.max(diameter,Math.max(leftCount,Math.max(rightCount,leftCount+rightCount+1)));
        return count;
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
