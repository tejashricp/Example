package DP;

/**
 * Created by TPathrikar on 8/20/2017.
 */
/*
* Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array
* such that the intgers in the subsequence are sorted in increasing order. For example,
* if input is {1, 101, 2, 3, 100, 4, 5},
* then output should be 106 (1 + 2 + 3 + 100),
* if the input array is {3, 4, 5, 10},
* then output should be 22 (3 + 4 + 5 + 10) and
* if the input array is {10, 5, 4, 3}, then output should be 10
*
* */

public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100, 4, 5};
        int maxSum = findMaxSumSubsequence(arr,0,arr[0]);
        System.out.println(maxSum);
        int[] arr1 = {3, 4, 5, 10};
        maxSum = findMaxSumSubsequence(arr1,0,arr1[0]);
        System.out.println(maxSum);
    }

    private static int findMaxSumSubsequence(int[] arr,int current,int lastNumber) {
        if(current>=arr.length)
            return 0;
        if(arr[current]<lastNumber)
            return findMaxSumSubsequence(arr,current+1,lastNumber);

        if(arr[current]>lastNumber)
            return arr[current]+findMaxSumSubsequence(arr,current+1,arr[current]);
        int max = Integer.MIN_VALUE;

        for (int i=0;i<arr.length;i++ ) {
            for(int j=i+1;j<arr.length;j++) {
                int localMax = arr[i] + findMaxSumSubsequence(arr, j, arr[i]);
                if (localMax > max)
                    max = localMax;
            }

        }
        return max;
    }
}
