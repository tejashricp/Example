package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by TPathrikar on 8/20/2017.
 */
public class LevelOrderTraversal {
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
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        list1.add(root);
        printLevelOrder(list1,list2);
    }

    private static void printLevelOrder(List<TreeNode> list1, List<TreeNode> list2) {
        if(list1.isEmpty() && list2.isEmpty())
            return;
        for (TreeNode node:list1){
            System.out.print(node.data+" ");
            if(node.right != null)
                list2.add(node.right);
            if(node.left != null)
                list2.add(node.left);
        }
        list1.clear();
        System.out.println();
        for (TreeNode node:list2){
            System.out.print(node.data+" ");
            if(node.right != null)
                list1.add(node.right);
            if(node.left != null)
                list1.add(node.left);
        }
        list2.clear();
        System.out.println();
        printLevelOrder(list1,list2);
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