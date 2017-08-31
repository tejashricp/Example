package Array;

/**
 * Created by TPathrikar on 8/31/2017.
 */
public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {7, 5, 3, 1};
        int[] arr2  = {9, 8, 6, 2, 0};
        int[] out = mergeArray(arr1,arr2);
        for(int i=0;i<out.length;i++){
            System.out.print(out[i]+" ");
        }
    }

    private static int[] mergeArray(int[] arr1, int[] arr2) {
        int[] out = new int[arr1.length+arr2.length];
        int i=0,j=0,k=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]) {
                out[k] = arr2[j];
                j = j+1;
            }
            else{
                out[k] = arr1[i];
                i = i+1;
            }
            k++;
        }

        if(i != arr1.length){
            while (i<arr1.length) {
                out[k] = arr1[i];
                i++;
                k++;
            }
        }
        if(j != arr2.length){
            while (j<arr2.length) {
                out[k] = arr2[j];
                j++;
                k++;
            }
        }
        return out;
    }
}
