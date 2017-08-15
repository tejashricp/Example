package Array;/*
*  Write a program to reverse an array
*Input: arr[] = {6, -3, -10, 0, 2}
* {2,0,-10,-3,6}
*Input: arr[] = {-1, -3, -10, 0, 60}
* {60,0,-10,-3,-1}
*Input: arr[] = {-2, -3, 0, -2, -40}
* {-40,-2,0,-3,-2}
* */


public class ReverseArray {
    public static void main(String[] args) {
        int[] input = {6, -3, -10, 0,2};
        int[] input1 = {-1, -3, -10, 0, 60};
        int[] input2 = {-2, -3,  -2, -40};
        input = reverseArray(input);
        printArray(input);
        input1 = reverseArray(input1);
        printArray(input1);
        input2 = reverseArray(input2);
        printArray(input2);
    }

    private static void printArray(int[] input) {
        for(int i=0;i<input.length;i++){
            System.out.print(input[i]+" ");
        }
        System.out.println();
    }

    private static int[] reverseArray(int[] input) {
        for(int i=0,j=input.length-1;i<input.length/2;i++,j--){
            int temp = input[j];
            input[j] = input[i];
            input[i] = temp;
        }
        return input;
    }
}

