package DP;

/**
 * Created by TPathrikar on 8/16/2017.
 */

/*
* Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
* Determine the maximum value obtainable by cutting up the rod and selling the pieces.
* For example, if length of the rod is 8 and
* the values of different pieces are given as following,
* then the maximum obtainable value is 22
* (by cutting in two pieces of lengths 2 and 6)
* length   | 1   2   3   4   5   6   7   8
--------------------------------------------
  price    | 1   5   8   9  10  17  17  20
*
* */
public class CuttingRod {

    public static void main(String[] args) {
        int[] arr = {1,   5,   8,   9,  10,  17,  17,  20};

        int maxCost = findMaxCost(arr,arr.length);
        System.out.println(maxCost);
    }

    private static int findMaxCost(int[] arr,int current) {
        if(current<=0)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<current ; i++) {
            int out  = arr[i]+findMaxCost(arr,current-i-1);;
            if(max<out)
                max = out;

        }
        return max;
    }

}
