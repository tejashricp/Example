package String;/*
*  1. Write a function to print the run length encoding of a given string.
*  Example :
*  I/P String – wwwwwxxxxddaaaww
*  O/P String – w5x4d2a3w2
* */


import java.io.UnsupportedEncodingException;

public class RunLengthOfCharacterInString {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String input = "wwwwwxxxxddaaaww";
        printRunLength(input);
    }

    private static void printRunLength(String input) {
        int count = 0;
        char temp = input.charAt(0);
        for (char c : input.toCharArray()) {
            if(count == 0){
                count++;
            }
            else if(temp == c)
                count++;
            else {
                System.out.print(temp+""+count);
                count=1;
            }
            temp = c;
        }
        System.out.print(temp+""+count);
    }
}
