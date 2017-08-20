package DP;

import java.util.ArrayList;
import java.util.Arrays;

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
        int[] temp = new int[arr.length];
        Arrays.fill(temp,-1);
        int maxSum = findMaxSumSubsequence(arr,0,arr[0],temp);

        System.out.println(maxSum);
        int[] arr1 = {3, 4, 5, 10};
        int[] temp1 = new int[arr1.length];
        Arrays.fill(temp1,-1);
        maxSum = findMaxSumSubsequence(arr1,0,arr1[0],temp1);
        System.out.println(maxSum);
    }

    private static int findMaxSumSubsequence(int[] arr,int current,int lastNumber,int[] temp) {
        if(current>=arr.length)
            return 0;
        if(arr[current]<lastNumber)
            return findMaxSumSubsequence(arr, current + 1, lastNumber,temp);
        if(arr[current]>lastNumber && temp[current] != -1)
            return temp[current];
        if(arr[current]>lastNumber) {
            temp[current] = arr[current] + findMaxSumSubsequence(arr, current + 1, arr[current],temp);
            return temp[current];
        }
        int max = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++ ) {
            for(int j=i+1;j<arr.length;j++) {
                int localMax = arr[i] + findMaxSumSubsequence(arr, j, arr[i],temp);
                if (localMax > max) {
                    temp[i] = localMax;
                    max = localMax;
                }
            }
        }
        return max;
    }
}
