/*
*  Given an integer array, find a maximum product of a triplet in array.
*  Input:  [10, 3, 5, 6, 20]
Output: 1200
Multiplication of 10, 6 and 20

Input:  [-10, -3, -5, -6, -20]
Output: -90

Input:  [1, -4, 3, -6, 7, 0]
Output: 168
* */





import java.util.*;

public class Demo {
    public static void main(String[] args) {
        int[] arr1 = {10, 3, 5, 6, 20};
        System.out.println(getMaxSumForTriplet(arr1));
        int[] arr2 =   {-10, -3, -5, -6, -20};
        System.out.println(getMaxSumForTriplet(arr2));
        int[] arr3 =   {1, -4, 3, -6, 7};
        System.out.println(getMaxSumForTriplet(arr3));
    }

    /*private static int getMaxSumForTriplet(int[] arr1) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for(int i = 0;i<arr1.length;i++) {
            if (max1 * max2 * max3 < arr1[i] * max2 * max3) {
                max1 = arr1[i];
                if (max1 < arr1[i]) {
                    max3 = max2;
                    max2 = max1;
                    max1 = arr1[i];
                }
            } else if (max1 * max2 * max3 < max1 * arr1[i] * max3){
                    max2 = arr1[i];
                if (max2 < arr1[i]) {
                    max3 = max2;
                    max2 = arr1[i];
                }
            }
            else if (max3 < arr1[i] || max1*max2*max3 < max1*max2*arr1[i])
                max3 = arr1[i];
        }

        return max1*max2*max3;
    }*/


    private static int getMaxSumForTriplet(int[] arr1) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for(int i = 0;i<arr1.length;i++){

            if(max1 < arr1[i]){
                max3 = max2;
                max2 = max1;
                max1 = arr1[i];
            }
            else if(max2 < arr1[i]){
                max3 = max2;
                max2 = arr1[i];
            }
            else if(max3 < arr1[i])
                max3 = arr1[i];
        }

        return max1*max2*max3;
    }


}

