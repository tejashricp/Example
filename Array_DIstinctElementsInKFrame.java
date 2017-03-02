/*
*  You are given an array of size n. Now print the number of distinct
*  elements in the array for every frame of size k.
* */


import java.io.UnsupportedEncodingException;
import java.util.HashSet;

public class Demo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        int input[] = {1, 2, 1, 3, 4, 3};
        int k =3;
        countDistinctNumbers(input,k);
    }

    private static void countDistinctNumbers(int[] input, int k) {
        HashSet hashSet = new HashSet();
        for(int i = 0;i<input.length;i++){
            for (int j = i; j - i < k && i+k<= input.length; j++) {

                if (!hashSet.contains(input[j]))
                    hashSet.add(input[j]);
            }
            printDistinctElements(hashSet);
            hashSet.clear();
        }
    }

    private static void printDistinctElements(HashSet hashSet) {
        for (Object o : hashSet) {
            System.out.print(o + " ");
        }
        System.out.println();
    }
}
