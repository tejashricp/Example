package Misc;


import java.util.Arrays;

/**
 * Created by TPathrikar on 8/21/2017.
 */

public class HackerRank {
    public static void main(String[] args) {
        int[] arr = {6,2,1,4,3,5};
        int x = 1;
        System.out.println("Perfectly Balanced".equals(getOutcomeOfTheFeat(arr,x)));
        int[] arr1 = {20,10,4,50,100};
        int y = 20;

        System.out.println("Balanced within 12".equals(getOutcomeOfTheFeat(arr1,y)));
    }

    static String getOutcomeOfTheFeat(int[] weights, int marginOfError) {
        Arrays.sort(weights);
        int rightSum = weights[weights.length-1];
        int leftSum = 0;
        boolean addedInLeft = false;
        for(int i = weights.length-2;i>=0;i--){
            if(rightSum>leftSum) {
                leftSum = leftSum + weights[i] + 1;
                addedInLeft = true;
            }
            else if(addedInLeft){
                rightSum = rightSum+weights[i];
                addedInLeft = false;
            }
        }
        if(rightSum == leftSum)
            return "Perfectly Balanced";
        else if( Math.abs(rightSum-leftSum)<=marginOfError)
            return "Balanced within "+Math.abs(rightSum-leftSum);

        return "Not Balanced";
    }
}
