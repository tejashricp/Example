import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/**
 Given an array with positive number the task is that
 we find largest subset from array that contain elements
 which are Fibonacci numbers. 
 Input : arr[] = {1, 4, 3, 9, 10, 13, 7};
 Output : subset[] = {1, 3, 13} The output three numbers are Fibonacci numbers.
 Input : arr[] = {0, 2, 8, 5, 2, 1, 4, 13, 23};
 Output : subset[] = {0, 2, 8, 5, 2, 1, 13, 23}
 */
public class Test{

    public static void main(String[] args) {
        int[] arr ={1, 4, 3, 9, 10, 13, 7};
        printFibonacciSeriesSubset(arr);
        System.out.println();
        int[] arr1 = {0, 2, 8, 5, 2, 1, 4, 13, 23};;
        printFibonacciSeriesSubset(arr1);
    }

    private static void printFibonacciSeriesSubset(int[] arr) {
        int max  = getMaxNumber(arr);
        HashSet<Integer> fibonacci = getFibonacciNumberLessThan(max);
        int i =0;
        while (i<arr.length){
            if(fibonacci.contains(arr[i]))
                System.out.print(arr[i]+" ");
            i++;
        }
    }

    private static HashSet<Integer> getFibonacciNumberLessThan(int max) {
        HashSet<Integer> fibonacci = new HashSet<>();
        util(fibonacci,max,0,0,0);
        return fibonacci;
    }

    private static void util(HashSet<Integer> fibonacci, int max, int current, int prev, int prevToPrev) {
        int sum = 0;
        if(current<=1) {
            sum = current;
            fibonacci.add(current);
        }
        else if(prev>=max)
            return;
        else {
            sum = prev + prevToPrev;
            fibonacci.add(sum);
        }
        prevToPrev = prev;
        prev = sum;
        current++;
        util(fibonacci,max,current,prev,prevToPrev);
    }

    private static int getMaxNumber(int[] arr) {
        int max  = Integer.MIN_VALUE;
        int i = 0;
        while(i<arr.length){
            if(max<arr[i])
                max = arr[i];
            i++;
        }
        return max;
    }
}


