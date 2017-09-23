package String;

/**
 * Created by TPathrikar on 9/15/2017.
 */
public class TrieSearchAndInsert {
    public static void main(String[] args) {
        Node root = new Node();
        insert("there",root);
        insert("these",root);
        insert("teja",root);
        insert("sample",root);
        System.out.println();
        System.out.println(search("there",root));
        System.out.println(search("sam",root));
        System.out.println(search("teja",root));
        System.out.println(search("",root));
    }

    private static boolean search(String str, Node root) {
        for(int i=0;i<str.length();i++){
            if(root.alphabets[str.charAt(i)-'a'] != null)
                root = root.alphabets[str.charAt(i)-'a'];
            else
                return false;
        }
        return root.endOfFile;
    }

    private static void insert(String str, Node root) {
        Node temp= null;
        for (int i =0; i<str.length();i++) {
            int index = str.charAt(i)-'a';
            if(root.alphabets[index] == null) {
                temp = new Node();
                root.alphabets[index] = temp;
                root = temp;
            }
            else
                root = root.alphabets[index];
        }
        if (temp != null)
        temp.endOfFile = true;
    }
}
class Node{
    Node[] alphabets = new Node[26];
    boolean endOfFile = false;
}
