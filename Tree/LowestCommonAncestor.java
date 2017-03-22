/*
*  Given a binary tree (not a binary search tree) and two values say n1 and n2,
*  write a program to find the least common ancestor.
*  
*  Approach 1
*  Following is simple O(n) algorithm to find LCA of n1 and n2.
1) Find path from root to n1 and store it in a vector or array.
2) Find path from root to n2 and store it in another vector or array.
3) Traverse both paths till the values in arrays are same. Return the common element just before the mismatch.
* */


import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        TreeNode root =  new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(4);
        TreeNode a4 = new TreeNode(5);
        TreeNode a5 = new TreeNode(6);
        TreeNode a6 = new TreeNode(7);
        TreeNode a7 = new TreeNode(8);

        root.left = a1;
        root.right =a2;

        a1.left = a3;
        a1.right = a4;


        a2.left = a5;
        a2.right = a6;

        a4.left = a7;

        System.out.println(findLowestCommonAncestor(root,a7,a6));

    }
//Approach1 start
    private static int findLowestCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
        List<Integer>  rootToN1 = new ArrayList<>();
        getRootToN1Path(root,n1,rootToN1);
        List<Integer>  rootToN2 = new ArrayList<>();
        getRootToN1Path(root,n2,rootToN2);
        int lca = compareListForLca(rootToN1,rootToN2);
        return lca;
    }

    private static Integer compareListForLca(List<Integer> rootToN1, List<Integer> rootToN2) {
        int i = rootToN1.size()-1,j = rootToN2.size()-1;
        for(;i>0&&j>0;i--,j--){
            if(rootToN1.get(i) != rootToN2.get(j))
                break;
        }

        return rootToN1.get(i+1);
    }

    private static boolean getRootToN1Path(TreeNode root, TreeNode n1,List<Integer> rootTon1) {
        if(root == n1){
            return true;
        }
        if(root == null)
            return false;
        if(getRootToN1Path(root.left,n1,rootTon1)) {
            rootTon1.add(root.data);
            return true;
        }
        if(getRootToN1Path(root.right,n1,rootTon1)) {
            rootTon1.add(root.data);
            return true;
        }
        return false;
    }

//Approach1 End

    public static class TreeNode {
        int data;
        TreeNode left ;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

}
