package Array;

/*
 * Given an array of n integers where each value represents number of chocolates in a packet.
 * Each packet can have variable number of chocolates. There are m students,
 * the task is to distribute chocolate packets such that:
 * Each student gets one packet.
 * The difference between the number of chocolates in packet with maximum chocolates and packet with minimum chocolates
 * given to the students is minimum.
 * */


import java.util.Arrays;

public class ChocolateDistribution {

    public static void main(String[] args) {
        int arr[] = {3, 4, 1, 9, 56, 7, 9, 12};
        int m = 5;
        System.out.println(findMinimumDifference(arr, m));
        int arr1[] = {7, 3, 2, 4, 9, 12, 56};
        m = 3;
        System.out.println(findMinimumDifference(arr1, m));
        int arr2[] = {12, 4, 7, 9, 2, 23, 25, 41,
                30, 40, 28, 42, 30, 44, 48,
                43, 50};
        m = 7;
        System.out.println(findMinimumDifference(arr2, m));
    }

    private static int findMinimumDifference(int[] arr, int m) {
        Arrays.sort(arr);
        int temp[] = new int[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            temp[i] = arr[i + 1] - arr[i];
        }
        int min = Integer.MAX_VALUE;
        int start = 0;
        int tempSum = 0;
        for (int i = 0; start + (m-1)-1 < temp.length; i++) {
            tempSum = tempSum + temp[i];
            if (i - start == (m-1)-1) {
                if (min > tempSum)
                    min = tempSum;
                tempSum = tempSum - temp[start];
                start = start + 1;
            }
        }
        return min;
    }
}
