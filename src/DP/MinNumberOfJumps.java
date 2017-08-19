package DP;

import java.util.Arrays;

/**
 * Created by TPathrikar on 8/19/2017.
 */
public class MinNumberOfJumps {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 4, 9, 2, 6, 7, 6, 8, 9};
        int[] temp = new int[arr.length];
        Arrays.fill(temp,-1);

        int jumps = findMinNumberOfJumps(arr,1,temp);
        System.out.println(jumps);
    }

    private static int findMinNumberOfJumps(int[] arr, int current,int temp[]) {
        if(current >= arr.length)
            return 0;
        if(arr[current-1] == 0)
            return Integer.MAX_VALUE;
        if(temp[current-1] != -1)
            return temp[current-1];
        int min = Integer.MAX_VALUE;
        for(int i = current+1;i<=current+arr[current-1] && i<=arr.length;i++){
            int jumps =  findMinNumberOfJumps(arr,i,temp);
            if(jumps != Integer.MAX_VALUE && min>jumps )
                min = jumps+1;
        }
       temp[current-1] = min;
        return min;
    }
}
