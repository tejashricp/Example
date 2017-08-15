package Array;/*
*  Print all subarrays of given array
* */


import java.io.UnsupportedEncodingException;

public class Array_PrintAllSubArray {
    public static void main(String[] args) throws UnsupportedEncodingException {
        int input[] = {1, 2, 3, 4};
        printSubArray(input);
    }

    private static void printSubArray(int[] input) {
        int startIndex = 0;
        int size = 1;
        int current = startIndex;
        while(size<= input.length){
            while (startIndex+size <= input.length){
                System.out.print(input[current]);
                current++;
                if(current-startIndex == size){
                    startIndex++;
                    current = startIndex;
                    System.out.println();
                }
            }
            size++;
            startIndex = 0;
            current =startIndex;
        }

    }




}
