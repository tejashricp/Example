package Tree;/*
*Given a directory like structure. Count all the folders.
* */

import java.util.ArrayList;
import java.util.List;

public class CountFolderInDirectory {
    public static int count = 1;

    public static void main(String[] args) {
        CustomTreeNode root = new CustomTreeNode("root");
        CustomTreeNode c1 = new CustomTreeNode("c1");
        CustomTreeNode c2 = new CustomTreeNode("c2");
        CustomTreeNode c3 = new CustomTreeNode("c3");
        CustomTreeNode d1 = new CustomTreeNode("d1");
        CustomTreeNode d2 = new CustomTreeNode("d2");
        CustomTreeNode d3 = new CustomTreeNode("d3");
        root.addChildNode(c1);
        root.addChildNode(c2);
        root.addChildNode(c3);
        c1.addChildNode(d1);
        c2.addChildNode(d2);
        c2.addChildNode(d3);

        count = getAllFolders(root);
        System.out.println(count);

    }

    private static int getAllFolders(CustomTreeNode root) {
        int count1 = 1;
        List<CustomTreeNode> child = root.childNodes;
        for (CustomTreeNode customTreeNode : child) {
            count1++;
            count1 = count1 + getAllFolders(customTreeNode);
        }

        return count1;
    }


}
class CustomTreeNode {
    String name;
    List<CustomTreeNode> childNodes;

    public CustomTreeNode(String name) {
        this.name = name;
        childNodes = new ArrayList<CustomTreeNode>();
    }

    public void addChildNode(CustomTreeNode treeNode){
        childNodes.add(treeNode);
    }

}
