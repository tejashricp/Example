package DP;/*
*
* The Longest Increasing Subsequence (LIS) problem is
* to find the length of the longest subsequence of a given sequence such
* that all elements of the subsequence are sorted in increasing order.
* For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6
* and LIS is {10, 22, 33, 50, 60, 80}.
*/



public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] input = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int out = longestIncreasingSubsequence(input);
        System.out.println(out);
    }
    private static int longestIncreasingSubsequence(int[] input) {
        int[] temp = new int[input.length];
        int[] actualSolution = new int[input.length];
        for(int i=0;i<input.length;i++){
            temp[i] = 1;
            actualSolution[i] = -1;
        }
        int i=0,j=1;
        while(true){
            if(j == input.length)
                break;
            while (i<j){
                if(input[i]<input[j] && temp[i]+1>temp[j]) {
                    temp[j] = temp[i] + 1;
                    actualSolution[j] = i;
                }
                i++;
            }
            j++;
            i=0;
        }
        int max = 0,maxIndex=0,k=0;
        for(k=0;k<input.length;k++){
            if(temp[k] > max) {
                max = temp[k];
                maxIndex = k;
            }
        }
        k = maxIndex;
        while(k>=0){
            System.out.print(input[k]);
            k = actualSolution[k];
        }

        return max;
    }
}

