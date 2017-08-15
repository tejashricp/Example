package Misc;

import java.util.Arrays;
import java.util.Collections;

/**
 Given two unsorted arrays A, B. They can contain duplicates.
 For each element in A count elements less than or equal to it in array B Examples:
 A={4,2,45,21,6,13}
 B={12,3,21,0,34}
 o/p{2,1,5,4,2,3}

 A={2,4,6,13,21,45}
 B={0,3,12,21,34}
 1,2,2,3,4,5

 * */
public class ArrProblem {
    public static void main(String[] args) {
        int[] A={4,2,45,21,6,13};
        int[] B={12,3,21,0,34};
        int[] result = getResult(A,B);
        printResult(result);

        int[] A1={1,1,1,1,1,1};
        int[] B1={12,3,21,10,34};//0,0,0,0,0,0
        int[] result1 = getResult(A1,B1);
        printResult(result1);

        int[] A2={4,2,45,21,6,13};
        int[] B2={12,3,4,0,4};//0,3,4,4,12
        int[] result2 = getResult(A2,B2);//4,1,5,5,4,5
        printResult(result2);

        int[] A3={4,2,45,21,6,13};
        int[] B3={12,3,21,0,34};//0,3,12,21,34
        int[] result3 = getResult(A3,B3);//2,1,5,4,2,3
        printResult(result3);
    }

    private static void printResult(int[] result) {
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }

    private static int[] getResult(int[] a, int[] b) {
        int[] result = new int[a.length];
        Arrays.sort(b);
        for(int i=0;i<a.length;i++){
            result[i] = getBinarySearch(a[i],b);
        }
        return result;
    }

    private static int getBinarySearch(int element, int[] b) {
        int start = 0;
        int end = b.length-1;

        while(start<end){
            int mid =  (start+end)/2;
            if(mid == start ) {
                if(b[start] == b[end])
                    return end+1;
                else if(b[end]<element)
                    return end+1;
                else if(b[mid]>element)
                    return mid;
                else
                    return mid+1;
            }

            if(element == b[mid])
                start =  mid;
            if(b[mid]<element)
                start = mid;
            if(b[mid]>element)
                end = mid;
        }
        return 0;
    }


}
