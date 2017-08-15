package Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 Given an array and a positive integer k, find the first negative integer for each
 and every window(contiguous subarray) of size k.
 If a window does not contain a negative interger,
 then print 0 for that window.*

 Input : arr[] = {-8, 2, 3, -6, 10}, k = 2
 Output : -8 0 -6 -6

 Input : arr[] = {12, -1, -7, 8, -15, 30, 16, 28} , k = 3
 Output : -1 -1 -7 -15 -15 0
//improve with o(n) operation complexity and o(1) space complexity
 */

public class FirstNegativeInKWindowOfArray {
    public static void main(String[] args) {
        int arr[] = {-8, 2, 3, -6, 10};
        int k = 2;
        printNegativeNumbersInKWindow(arr,k);
        System.out.println();
        int arr1[] = {12, -1, -7, -8, 30, 16, 28,-15, 30, 16, 28} ;
        int k2 = 3;
        printNegativeNumbersInKWindow(arr1,k2);
    }

    //not working soln
    private static void printNegativeNumbersInKWindow(int[] arr, int k) {
        int start = 0;
        int firstNegative = 0;
        boolean skip = false;
        for(int i =0;i<arr.length;i++){
            if(arr[i]<0 && firstNegative ==0)
                firstNegative = (arr[i]);
            if(i-start == k-1){
                if(!skip)
                System.out.print(firstNegative+" ");
                if(firstNegative == arr[start])
                    firstNegative = 0;
                start++;
                if(arr[start]<0) {
                    System.out.print(arr[start]+" ");
                    skip = true;
                }
                else
                    skip = false;
            }

        }
    }

    //complexity o(n) and space o(n)
    //working soln
    private static void printNegativeNumbersInKWindowWithStack(int[] arr, int k) {
        int start = 0;
        int count = 0;
        Queue<Integer> firstNegative = new LinkedList<>();
        for(int i =0;i<arr.length;i++){
            if(arr[i]<0)
                firstNegative.add(arr[i]);
            if(i-start == k-1){
                System.out.print(firstNegative.isEmpty()?"0":firstNegative.peek()+" ");
                if(!firstNegative.isEmpty() && firstNegative.peek() == arr[start])
                    firstNegative.poll();
                start++;
            }

        }
    }

}
