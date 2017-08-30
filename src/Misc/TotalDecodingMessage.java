package Misc;

import java.util.Arrays;

/**
 * Created by TPathrikar on 8/30/2017.
 */


/*
* A top secret message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
You are an FBI agent. You have to determine the total number of ways that message can be decoded.
Note: An empty digit sequence is considered to have one decoding. It may be assumed that the input contains valid digits from 0 to 9 and If there are leading 0’s, extra trailing 0’s and two or more consecutive 0’s then it is an invalid string.

Example :
Given encoded message "123",  it could be decoded as "ABC" (1 2 3) or "LC" (12 3) or "AW"(1 23).
So total ways are 3.

Input:
First line contains the test cases T.  1<=T<=1000
Each test case have two lines
First is length of string N.  1<=N<=40
Second line is string S of digits from '0' to '9' of N length.

Example:
Input:
2
3
123
4
2563
Output:
3
2
*
*
*
* */
public class TotalDecodingMessage {
    public static void main(String[] args) {
        String input = "123";
        int[] temp = new int[input.length()];
        Arrays.fill(temp,-1);
        System.out.println(getTotalNumberOfPossibleDecodedMessages(input,0,0,temp));
        String input1  = "2563";
        int[] temp1 = new int[input1.length()];
        Arrays.fill(temp1,-1);
        System.out.println(getTotalNumberOfPossibleDecodedMessages(input1,0,0,temp1));
    }


    private static int getTotalNumberOfPossibleDecodedMessages(String input,int start, int ways,int[] temp) {
        if(start == input.length()-1 || start == input.length())
            return 1;
        if(start > input.length())
            return 0;
        if(temp[start] != -1)
            return temp[start];
        if(start+1 < input.length() && Integer.parseInt(input.substring(start,start+2))<= 26) {
            temp[start] =  ways + getTotalNumberOfPossibleDecodedMessages(input, start + 2, ways, temp) +
                    getTotalNumberOfPossibleDecodedMessages(input, start + 1, ways, temp);
            return temp[start];
        }
        else {
            temp[start] =  ways + getTotalNumberOfPossibleDecodedMessages(input, start + 1, ways, temp);
            return temp[start];
        }
        }
}
