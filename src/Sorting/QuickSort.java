package Sorting;

/**
 * Created by TPathrikar on 9/26/2017.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        quickSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    private static void quickSort(int[] arr,int low,int high) {
        if (low<high) {
            int pivot = updatePivot(arr, low, high);
            quickSort(arr,low,pivot-1);
            quickSort(arr,pivot+1,high);
        }
    }

    private static int updatePivot(int[] arr, int low, int high) {
        int pivot = high;
        while (low<=high){
            if(arr[low]>arr[pivot]) {
                if(pivot == high)
                    pivot = low;
                swap(arr, low, high);
                high--;
            }
            else {
                if(pivot<low) {
                    swap(arr, pivot, low);
                    pivot = low;
                }
                low++;
            }
        }

        return pivot;
    }

    private static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
