package DP;

import java.util.HashMap;

/**
 * Created by TPathrikar on 8/16/2017.
 */

/*
* Given a value N, if we want to make change for N cents,
* and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
* how many ways can we make the change? The order of coins doesn’t matter.
For example, for N = 4 and S = {1,2,3},
there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
 So output should be 4.
 For N = 10 and S = {2, 5, 3, 6},
 there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
*
* */

public class CoinChange {

    public static void main(String[] args) {
        int[] arr = {2,3,5,6};
        int n = 10;
        int ways = 0;
        HashMap<String,Integer> hashMap = new HashMap<>();
        ways = findCoinChangeWays(arr,n,arr.length,hashMap);
        System.out.println(ways);
        int[] arr1 = {1,2,3};
        int n1 = 4;
        int ways1 = 0;
        HashMap<String,Integer> hashMap1 = new HashMap<>();
        ways1 = findCoinChangeWays(arr1,n1,arr1.length,hashMap1);
        System.out.println(ways1);

    }

    private static int findCoinChangeWays(int[] arr, int n, int size, HashMap<String,Integer> hashMap) {
        if(n==0)
            return 1;

        if(size<=0 && n>=1)
            return 0;
        if(n<0)
            return 0;
        if(hashMap.containsKey(n+""+size))
            return hashMap.get(n+""+size);
        else
            hashMap.put(n+""+size,findCoinChangeWays(arr,n,size-1,hashMap)+ findCoinChangeWays(arr,n-arr[size-1],size,hashMap));
        return hashMap.get(n+""+size);
    }

    }
