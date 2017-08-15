/**
 * Created by TPathrikar on 8/3/2017.
 Insertion sort
 i/p:3 2 6 1 4 5
 o/p:1 2 3 4 5 6
 *
 * */

public class Test1 {

    public static void main(String[] args) {
        int[] inp = {3, 2, 6, 1, 4, 5};
        doInsertionSort(inp);
        for(int i=0;i<inp.length;i++) {
            System.out.print(inp[i]+" ");
        }
    }

    private static void doInsertionSort(int[] inp) {
        //3 2 6 1 4 5
        for(int i=1;i<inp.length;i++){
            int j = i-1;
            while (j>=0){
                if(inp[j]>inp[j+1]) 
                    swap(inp, j, j+1);
                else
                    break;
                j--;
            }
        }
    }

    private static void swap(int[] inp, int j, int i) {
        int temp = inp[i];
        inp[i] = inp[j];
        inp[j] = temp;
    }


}
