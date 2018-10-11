package Array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class KthElementInTwoSortedArrays {

    public static void main(String[] args) {
        int arr1[] = {12, 34, 2, 5, 123, 78};
        int arr2[] = {98, 54, 33, 7, 2, 90};
        int k = 5;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        findKthElement(arr1, arr2, k);
        System.out.println();
    }

    // iterate from last element of arr2 and compare with last element of arr1
    // find correct place of arr2 element in arr1 if less that last element of arr1
    // cache last element of arr1 and move all elements till the correct place to right in arr1
    // replace add arr2 element in arr1 correct place and arr1 last element in arr2 element's place
    private static void findKthElement(int[] arr1, int[] arr2, int k) {
        int j = arr2.length-1, i = arr1.length-1;
        int m = arr1.length-1;
        for(;j>=0;j--){
                int last = arr1[i];
                while (arr2[j]<arr1[m] && arr2[j] < arr1[m-1] && m > 0){
                    arr1[m] = arr1[m-1];
                    m--;
                }
                arr1[m] = arr2[j];
                arr2[j] = last;
                m = arr1.length-1;
        }
    }
}
