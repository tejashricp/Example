package Tree;

/**
 * Created by TPathrikar on 9/5/2017.
 */
public class SearchAndInsertInBST {
    public static void main(String[] args) {
        Node root = new Node(8);
        Node a1 = new Node(3);
        Node a2 = new Node(10);
        Node a3 = new Node(1);
        Node a4 = new Node(6);
        Node a5 = new Node(4);
        Node a6 = new Node(7);
        Node a7 = new Node(14);
        Node a8 = new Node(13);
        root.left = a1;
        root.right = a2;

        a1.left = a3;
        a1.right = a4;

        a4.left = a5;
        a4.right = a6;

        a2.right = a7;

        a7.left = a8;

        Node node = searchInBST(root,1);
        System.out.println(node.data);
        insertIntoBST(root,12,null);
        inorder(root);
    }

    private static void inorder(Node root) {
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }


    private static void insertIntoBST(Node root, int i,Node prev) {
        if(root == null && prev.data<i) {
            prev.right = new Node(i);
            return;
        }
        if(root == null && prev.data>=i) {
            prev.left = new Node(i);
            return;
        }
        if(root.data<i)
            insertIntoBST(root.right, i, root);
        else
            insertIntoBST(root.left,i,root);
    }

    private static Node searchInBST(Node root, int i) {
        if(root == null || root.data == i)
            return root;
        if(root.data<i)
             return searchInBST(root.right,i);
        else
           return searchInBST(root.left,i);
    }


    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

}
