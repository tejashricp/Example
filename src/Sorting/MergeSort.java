package Sorting;

import java.util.Arrays;

/**
 * Created by TPathrikar on 9/1/2017.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] input = {23,2,12,45,6,4,32,43,55,87,90,3};
        input = mergeSort(input);
        System.out.println(Arrays.toString(input));
    }

    private static int[] mergeSort(int[] input) {
        if(input.length<=1)
            return input;
        int start = 0,end = input.length;
            int mid = input.length/2;
            int first = start;
            int second = mid;
            int[] firstArr = new int[mid];
            int[] secondArr = new int[end-mid];
            System.arraycopy(input,first,firstArr,0,firstArr.length);
            System.arraycopy(input,second,secondArr,0,secondArr.length);
            mergeSort(firstArr);
            mergeSort(secondArr);

            util(firstArr,secondArr,input);
            return input;
    }

    private static void util(int[] firstArr, int[] secondArr, int[] input) {
        int iFirst = 0;
        int iSecond = 0;
        int iMerge = 0;
        while(iFirst<firstArr.length && iSecond<secondArr.length){
            if(firstArr[iFirst]<secondArr[iSecond]) {
                input[iMerge] = firstArr[iFirst];
                iFirst++;
            }
            else {
                input[iMerge] = secondArr[iSecond];
                iSecond++;
            }
            iMerge++;
        }
        System.arraycopy(firstArr, iFirst, input, iMerge, firstArr.length - iFirst);
        System.arraycopy(secondArr, iSecond, input, iMerge, secondArr.length - iSecond);
    }

 }
