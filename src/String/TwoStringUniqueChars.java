package String;

import java.util.HashSet;

/*
* write a program to print unique alphabets and common characters from two strings
*
* */

public class TwoStringUniqueChars {

    public static void main(String[] args) {
        String st1 = "I am living in India";
        String st2 = "India is a beautiful country";

        HashSet<Character> firstUnique = getFirst(st1);
        HashSet<Character> result = getSecond(st2,firstUnique);

        printSet(result);
    }

    private static void printSet(HashSet<Character> result) {
        for (Character character : result) {
            System.out.print(character + " ");
        }
    }


    private static HashSet<Character> getSecond(String st2, HashSet<Character> firstUnique) {
        HashSet<Character> result = new HashSet<Character>();
        for (char c : st2.toCharArray()) {
            if(firstUnique.contains(c))
               result.add(c);
        }
        return result;
    }

    private static HashSet<Character> getFirst(String st1) {
        HashSet<Character> hashSet = new HashSet();
        for (char c : st1.toCharArray()) {
            if(c != ' ' )
                hashSet.add(c);
        }
        return hashSet;
    }
}
