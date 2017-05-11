/*
* Print distinct number in every k frame of an array
* int[] input= {11,32,43,11,23,32,23,11,56,13,11};
* k=3
* o/p
* 11 32 43
* 32 43 11
* 43 11 23
* 11 23 32
* 23 32
* 32 23 11
* 23 11 56
* 11 56 13
* 56 13 11
*
* */

import java.util.*;

public class Demo {

    public static void main(String[] args) {
        int[] input= {11,32,43,11,23,32,23,11,56,13,11};
        int k = 3;
        printCountDistinctElements(input,k);
        printKDistinctElements(input,k);
    }

    private static void printKDistinctElements(int[] input,int k) {
        int index = 0;
        int start = 0;
        int distinct = 0;
        HashMap<Integer,Integer> hm = new LinkedHashMap<>();
        while (index < input.length){
            if(hm.containsKey(input[index])){
                int freq = hm.get(input[index]);
                hm.put(input[index],freq+1);
            }
            else
                hm.put(input[index],1);
            index++;
            if(index >= k){
                System.out.println();
                printElementsofHashMap(hm);
                if(hm.get(input[start])>1){
                    int freq = hm.get(input[start]);
                    hm.put(input[start],freq-1);
                }
                else
                    hm.remove(input[start]);
                start = start+1;
            }

        }

    }

    private static void printElementsofHashMap(HashMap<Integer, Integer> hm) {
        for (Integer key : hm.keySet()) {
            System.out.print(key+" ");
        }
    }

    private static void printCountDistinctElements(int[] input, int k) {
        int start = 0;
        int index = 0;
        int distinct = 0;
        boolean added = false;
        HashSet<Integer> uniqueElements = new HashSet<>();
        while(index < input.length){
            if(!uniqueElements.contains(input[index])){
                distinct++;
                uniqueElements.add(input[index]);
                added = true;
            }
            else
                added = false;

            index++;
            if(index >= k) {
                System.out.println(distinct);
                uniqueElements.remove(input[start]);
                if(added)
                    distinct--;
                start = start+1;
            }
        }
    }


}
