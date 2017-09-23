package Tree;

/**
 * Created by TPathrikar on 9/15/2017.
 */
public class SwappedNodesInBST {

    public static void main(String[] args) {
        CustomNode root = new CustomNode(8);
        CustomNode a1 = new CustomNode(3);
        CustomNode a2 = new CustomNode(10);
        CustomNode a3 = new CustomNode(1);
        CustomNode a4 = new CustomNode(6);
        CustomNode a5 = new CustomNode(4);
        CustomNode a6 = new CustomNode(7);
        CustomNode a7 = new CustomNode(14);
        CustomNode a8 = new CustomNode(13);
        root.left = a1;
        root.right = a2;

        a1.left = a3;
        a1.right = a4;

        a4.left = a5;
        a4.right = a6;

        a2.right = a7;

        a7.left = a8;

    }

}
class CustomNode{
    int data;
    CustomNode left;
    CustomNode right;

    public CustomNode(int data) {
        this.data = data;
    }
}
