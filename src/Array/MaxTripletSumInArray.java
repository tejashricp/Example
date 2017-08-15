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
        System.out.println(getMaxProductForTriplet1(arr1));
        int[] arr2 =   {-10, -3, -5, -6, -20};
        System.out.println(getMaxProductForTriplet1(arr2));
        int[] arr3 =   {1, -4, 3, -6, 7};
        System.out.println(getMaxProductForTriplet1(arr3));
    }
//works for all negative n positive inputs
        private static int getMaxProductForTriplet1(int[] arr1) {
        int max[] = new int[3];
        int min[] = new int[3];

        Queue<Integer> maxHeap = new PriorityQueue<Integer>(3, Collections.reverseOrder());
        Queue<Integer> minHeap = new PriorityQueue<>(3);

        for (int i = 0; i < arr1.length; i++) {
            maxHeap.add(arr1[i]);
            minHeap.add(arr1[i]);
        }
        int maxProduct = 1;
        int minProduct =  1;
        for(int i=0;i<3;i++){
         max[i] = maxHeap.poll();
         min[i] = minHeap.poll();
        }
        maxProduct = max[0]*max[1]*max[2];
        minProduct = min[0]*min[1]*max[0];
        return  maxProduct>minProduct?maxProduct:minProduct;

    }
//works only for positive input
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

