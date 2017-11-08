package String;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

/**
 * Created by TPathrikar on 11/5/2017.
 */
public class PalindromeSubstring {
    public static void main(String[] args) {
        String input = "NITIN";
        printSubseq(input,0,1);
        input = "geeks";
        printSubseq(input,0,1);
        input = "AAa";
        printSubseq(input,0,1);
    }

    private static void printSubseq(String input,int index,int size) {
        if(size > input.length())
            return;
        else if(index >= input.length())
            printSubseq(input,0,size+1);
        else if(index+size>input.length())
            printSubseq(input,index+1,size);
        else {
            if(isPalindrome(input.substring(index, size + index)))
                System.out.println(input.substring(index, size + index));
            printSubseq(input, index + 1, size);
        }
    }

    private static boolean isPalindrome(String substring) {
     for(int i=0,j=substring.length()-1;i<j;i++,j--){
         if(substring.charAt(i) != substring.charAt(j) && Math.abs(substring.charAt(i)-substring.charAt(j)) != 32)
             return false;
     }
     return true;
    }


}
