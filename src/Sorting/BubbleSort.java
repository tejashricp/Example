package Sorting;

/**
 * Created by TPathrikar on 8/3/2017.
 Bubble sort
 i/p:7 2 16 1 4 5
 o/p:1 2 4  5 7 16
 * this is inplace sorting as we are using same array space
 * at a time compares betn current number and next element
 *in this way in one pass u get largest elemnt at the end
 * this is the best algo to sort an array which has only one
 * element out of place
 * */

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {7, 2, 16, 1, 4, 5};
        doBubbleSort(arr);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }

    private static void doBubbleSort(int[] arr) {
        boolean swap = true;
        int k = arr.length-1;
        while(swap) {
            swap = false;
            for(int i=0;i<=k-1;i++){
                if(arr[i]>arr[i+1]) {
                    swap(arr, i, i + 1);
                    swap = true;
                }
            }
            k--;
        }
    }

    private static void swap(int[] arr, int min, int index) {
        int temp = arr[min];
        arr[min] = arr[index];
        arr[index] = temp;
    }


}
