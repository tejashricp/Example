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

    private static void findKthElement(int[] arr1, int[] arr2, int k) {
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                i++;
            } else if (arr1[i] < arr2[j])
                i++;
            else if (arr1[i] > arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                if(arr2[j+1] >= temp){
                    i++;
                    arr2[j] = temp;
                    j++;
                }
                else {
                    j++;
                }
            }
        }
    }
}
