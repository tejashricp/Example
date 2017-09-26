package Array;

/**
 * Created by tpathrikar on 9/25/2017.
 */

/*
* find maximum of a[j]-a[i] for (i<j)
* {12,    2,   34,   11,   55,   12,   3,  8}
*   12    2     2     2     2     2    2    2
*
*   {34,   8,    10,   3,   2,   80,   30,   33,   1}
*    34    8     8     3    2     2     2     2    1
*
* 9,   15,   4,   12,   13
* 9     9    4     4     4
* 0     6    0     8     9
* */
public class MaxDiffInArrayElements {

    public static void main(String[] args) {
        int[] arr = {34,   8,    10,   3,   2,   80,   30,   33,   1};
        System.out.println(findMaxDif(arr));
        int[] arr1 = {9,   15,   4,   12,   13};
        System.out.println(findMaxDif(arr1));
    }

    private static int findMaxDif(int[] arr) {
        int[] temp = new int[arr.length];
        int min = arr[0];
        temp[0] = Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            temp[i] = min;
            if(min>arr[i])
                min = arr[i];
        }
        int max = Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++){
            if(max<arr[i]-temp[i])
                max = arr[i]-temp[i];
        }
        return max;
    }

}
