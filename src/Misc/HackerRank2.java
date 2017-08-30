package Misc;

import java.util.*;

/**
 * Created by TPathrikar on 8/21/2017.
 */
public class HackerRank2 {
    public static void main(String[] args) {
        int[] arr = {1,11,11,11,23,11,37,51,37,37};
        int k =2;
        System.out.println(getLargestNumberWithPrimeOccurences(arr,k));
    }

    static int getLargestNumberWithPrimeOccurences(int[] inputArray, int minOccurence) {
        HashSet primeNumHash = createHashSet(primeNum);
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int input : inputArray) {
            if(hashMap.containsKey(input)) {
                int occur = hashMap.get(input);
                hashMap.put(input,occur+1);
            }
            else
                hashMap.put(input,1);
        }
        int out = -1;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : hashMap.entrySet()) {
            int key = integerIntegerEntry.getKey();
            int value = integerIntegerEntry.getValue();
            if(value>=minOccurence && primeNumHash.contains(value) && key>out)
                out = key;
        }
        return out;
    }

    static HashSet<Integer> primeNumHashSet = new HashSet();
    static int [] primeNum = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,73,79,83,89,97};

    private static HashSet createHashSet(int[] primeNum) {
        if(primeNumHashSet.isEmpty()) {
            for (int i : primeNum) {
                primeNumHashSet.add(i);
            }
        }
        return primeNumHashSet;
    }

}
