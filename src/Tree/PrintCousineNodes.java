package Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by TPathrikar on 8/20/2017.
 */
public class PrintCousineNodes {
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
        HashSet<TreeNode> list1 = new HashSet<>();
        HashSet<TreeNode> list2 = new HashSet<>();
        list1.add(root);
        list1 = printLevelOrder(list1,list2,a3);
        for (TreeNode treeNode : list1) {
            System.out.println(treeNode.data+" ");
        }
    }

    private static HashSet<TreeNode> printLevelOrder(HashSet<TreeNode> nodeHashSet1,HashSet<TreeNode> treeNodeHashSet2, TreeNode node) {
        if(nodeHashSet1.isEmpty() && treeNodeHashSet2.isEmpty())
            return null;
        for (TreeNode node1:nodeHashSet1){
                if (node1.right != null && node1.left != null && node1.left.data != node.data)
                    treeNodeHashSet2.add(node1.right);
                if (node1.left != null && node1.right != null && node1.right.data != node.data)
                    treeNodeHashSet2.add(node1.left);
        }
        nodeHashSet1.clear();
        if(treeNodeHashSet2.contains(node)) {
            treeNodeHashSet2.remove(node);
            return treeNodeHashSet2;
        }

        for (TreeNode node1:treeNodeHashSet2){
                if (node1.right != null && node1.left != null && node1.left.data != node.data)
                    nodeHashSet1.add(node1.right);
                if (node1.left != null && node1.right != null && node1.right.data != node.data)
                    nodeHashSet1.add(node1.left);
        }
        treeNodeHashSet2.clear();
        if(nodeHashSet1.contains(node)) {
            nodeHashSet1.remove(node);
            return nodeHashSet1;
        }
        printLevelOrder(nodeHashSet1,treeNodeHashSet2,node);
        return null;
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
