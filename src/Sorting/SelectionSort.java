/**
 * Created by TPathrikar on 8/3/2017.
 Selection sort
 i/p:7 2 16 1 4 5
 o/p:1 2 4  5 7 16
 * this is inplace sorting as we are using same array space
 * and replacing min element with correct index
 *
 * */

public class Test1 {

    public static void main(String[] args) {
        int[] arr = {7, 2, 16, 1, 4, 5};
        doSelectionSort(arr);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }

    private static void doSelectionSort(int[] arr) {
        int start = 0;
        int index = 0;
        int min = Integer.MIN_VALUE;
        while(start<arr.length-1) {
            for (int i = start; i < arr.length; i++) {
                if(min<0 || arr[min]>arr[i])
                    min = i;
            }
            swap(arr,min,index);
            start++;
            index++;
            min = -1;
        }
    }

    private static void swap(int[] arr, int min, int index) {
        int temp = arr[min];
        arr[min] = arr[index];
        arr[index] = temp;
    }


}
