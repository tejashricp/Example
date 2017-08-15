package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TPathrikar on 8/15/2017.
 */
public class VerticalView {
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
        Map<Integer,List<Integer>> integerMap = new HashMap<>();
        verticalView(root,integerMap,0);
        for (Map.Entry<Integer, List<Integer>> integerListEntry : integerMap.entrySet()) {
            List<Integer> arr = integerListEntry.getValue();
            for (Integer integer : arr) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }

    private static void verticalView(TreeNode root, Map<Integer, List<Integer>> integerMap, int distance) {
        if(root == null)
            return;
        if(integerMap.containsKey(distance)) {
            List arr = integerMap.get(distance);
            arr.add(root.data);
        }
        else {
            List<Integer> integerList = new ArrayList<>();
            integerList.add(root.data);
            integerMap.put(distance,integerList);
        }
        verticalView(root.left,integerMap,distance+1);
        verticalView(root.right,integerMap,distance-1);
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
