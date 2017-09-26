package Sorting;

/**
 * Created by TPathrikar on 9/25/2017.
 */
/*
* The problem is similar to our old post Segregate 0s and 1s in an array,
* and both of these problems are variation of famous Dutch national flag problem.
*
* */
public class SortArrayOf012 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sortDNF(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
        System.out.println();
        int[] arr1 = {1,0,0,0,1,0,1,1,0,1,0,1};
        sort0And1(arr1);
        for(int i=0;i<arr1.length;i++){
            System.out.print(arr1[i]);
        }
    }

    private static void sort0And1(int[] arr1) {
        int low = 0;
        int high = arr1.length-1;
        while (low<=high){
            switch (arr1[low]){
                case 0:
                    low++;
                    break;
                case 1:
                    swap(arr1,low,high);
                    high--;
            }
        }
    }

    private static void sortDNF(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length-1;
        while (mid <= high){
            switch (arr[mid]) {
                case 0:
                    swap(arr,low, mid);
                    mid++;
                    low++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr,high,mid);
                    high--;
                    break;
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
