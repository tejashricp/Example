package Tree;

import java.util.HashMap;

/**
 * Created by TPathrikar on 9/10/2017.
 */

/*
* n a BST, each node has an additional attribute ‘score’ along with the value. You need to write two functions:
a. Update(value, newScore) -> update the score of the node with value ‘value’ to the newScore
b. SubTreeScore(value) -> get the sum of scores of all nodes in the subtree with node having the value ‘value’ as the root
* */
public class SumTree {
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

        populateTree(root);
        inorder(root);
    }

    private static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        //System.out.print(root.sumValue+" ");
        inorder(root.right);
    }

    static HashMap<Integer,Integer> valueSumvalueMap = new HashMap<>();
    private static int populateTree(Node root) {
        if (root == null)
            return 0;
        int leftSum = populateTree(root.left);
        int rightSum = populateTree(root.right);
        int sumValue = leftSum+rightSum;
        valueSumvalueMap.put(root.data,sumValue);
        return sumValue+root.data;
    }

    public Integer subTreeScore(int value){
        return valueSumvalueMap.get(value);
    }

    public void update(int value, int newScore, Node root){
        if(root == null)
            return;
        if(root.data == value)
            root.score = newScore;
        if(root.data < value)
            update(value,newScore,root.right);
        else
            update(value,newScore,root.left);
    }

    }
    class Node{
        int data;
        Node left;
        Node right;
        int score;

        public Node(int data){
            this.data = data;
        }
    }
