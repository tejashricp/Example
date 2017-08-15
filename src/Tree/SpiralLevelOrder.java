package Tree;

import java.util.Stack;

/**
 * Level order Traversal in spiral form.


 */
public class SpiralLevelOrder {
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
        root.right =a2;     //     0
                            //    / \
                            //   1        2
                            //  / \      / \
                            // 3    4   5   6
        a1.left = a3;    //   /\     \
        a1.right = a4;   //  7  8    10
                        //     /     /
                        //    9     11
        a2.right = a6;
        a2.left = a5;

        a3.left = a7;
        a3.right = a8;

        a4.right = a10;

        a8.left = a9;

        a10.left = a11;

        //a2.left = a5;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);
        printInSpiralForm(stack1,stack2);

    }

    private static void printInSpiralForm(Stack<TreeNode> stack1, Stack<TreeNode> stack2) {
        if(stack1.isEmpty() && stack2.isEmpty())
            return;
        System.out.println();
        while(!stack1.isEmpty()) {
            TreeNode root = stack1.pop();
            System.out.print(root.data+" ");
            if (root.left != null)
                stack2.push(root.left);
            if (root.right != null)
                stack2.push(root.right);
        }
        System.out.println();
        while (!stack2.isEmpty()) {
            TreeNode root = stack2.pop();
            System.out.print(root.data+" ");
            if (root.right != null)
                stack1.push(root.right);
            if (root.left != null)
                stack1.push(root.left);
        }
        printInSpiralForm(stack1,stack2);
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

