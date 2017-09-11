package Array;

/**
 * Created by TPathrikar on 9/4/2017.
 */
public class InsertElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {12,24,56,58,58,90,91,101,111};
        int n = 57;
        insertElement(arr,n);
    }

    private static void insertElement(int[] arr,int n) {
        int index = searchIndex(arr,n,0,arr.length);
    }

    private static int searchIndex(int[] arr, int n1, int start, int end) {

        return 0;
    }
}
