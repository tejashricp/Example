import java.util.Stack;

/**
 * Created by TPathrikar on 8/3/2017.
 */
public class Test1 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);

        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);
        TreeNode a7 = new TreeNode(7);
        TreeNode a8 = new TreeNode(8);
        TreeNode a9 = new TreeNode(9);
        TreeNode a10 = new TreeNode(10);
        TreeNode a11 = new TreeNode(11);
        TreeNode a12 = new TreeNode(12);
        root.leftPrev = a1;
        root.rightNext = a2;     //     0
        //    / \
        //   1        2
        //  / \      / \
        // 3    4   5   6
        a1.leftPrev = a3;    //   /\     \       \
        a1.rightNext = a4;   //  7  8    10       12
        //     /     /
        //    9     11
        a2.rightNext = a6;
        a2.leftPrev = a5;

        a3.leftPrev = a7;
        a3.rightNext = a8;

        a4.rightNext = a10;
        a6.rightNext = a12;
        a8.leftPrev = a9;

        a10.leftPrev = a11;

        //a2.left = a5;
        Stack<TreeNode> treeNodeStack1 = new Stack<>();
        Stack<TreeNode> treeNodeStack2 = new Stack<>();

        treeNodeStack1.push(root);
        levelOrder(treeNodeStack1,treeNodeStack2,null);
        System.out.println();
        printDLL(root);
    }

    private static void printDLL(TreeNode root) {
        while (root != null){
            System.out.print(root.data +" ");
            root = root.rightNext;
        }
    }

    public static void levelOrder(Stack<TreeNode> stack1,Stack<TreeNode> stack2,TreeNode prev){
        if(stack1.isEmpty() && stack2.isEmpty())
            return;
        while (!stack1.isEmpty()){
            TreeNode  n = stack1.pop();
            System.out.print(n.data+" ");
            if(n.rightNext != null)
                stack2.push(n.rightNext);
            if (n.leftPrev != null)
                stack2.push(n.leftPrev);
            if(prev != null)
            prev.rightNext = n;
            n.leftPrev = prev;
            prev = n;
        }
        System.out.println();
        while (!stack2.isEmpty()){
            TreeNode  n = stack2.pop();
            System.out.print(n.data+" ");
            if(n.leftPrev != null)
                stack1.push(n.leftPrev);
            if(n.rightNext != null)
                stack1.push(n.rightNext);
            prev.rightNext = n;
            n.leftPrev = prev;
            prev = n;
        }
        System.out.println();
        levelOrder(stack1,stack2,prev);
    }


    public static class TreeNode {
        int data;
        TreeNode leftPrev;
        TreeNode rightNext;

        public TreeNode(int data) {
            this.data = data;
        }
    }


}
