/*
*  You are given an array of size n. Now print the number of distinct
*  elements in the array for every frame of size k.
* */


import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;

public class Demo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        int input[] = {1, 2, 1, 3, 4, 3};
        int k =3;
        countDistinctNumbers(input,k);
    }

    private static void countDistinctNumbers(int[] input, int k) {
        HashMap out = new HashMap();
        int i =0;
        int j= i;
        while(i+k<= input.length){
            if(j-i>= k) {
                printDistinctElements(out);
                out.clear();
                i++;
                j = i;
            }
            else {
                if (!out.containsValue(input[j]))
                    out.put(j,input[j]);
                j++;
            }
        }
    }

    private static void printDistinctElements(HashMap hashSet) {
        Object[] arr= hashSet.keySet().toArray();
        Arrays.sort(arr);
        for (Object o : arr) {
            System.out.print(hashSet.get(o) + " ");
        }
        System.out.println();
    }
}
