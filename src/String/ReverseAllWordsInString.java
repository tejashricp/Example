package String;

/**
 * Created by TPathrikar on 8/30/2017.
 */
/*
* Given a String of length N reverse the words in it. Words are separated by dots.

Input:
The first line contains T denoting the number of testcases. Then follows description of testcases. Each case contains a string containing spaces and characters.


Output:
For each test case, output a single line containing the reversed String.

Constraints:
1<=T<=20
1<=Lenght of String<=2000


Example:
Input:
2
i.like.this.program.very.much
pqr.mno

Output:
much.very.program.this.like.i
mno.pqr
*
* */


public class ReverseAllWordsInString {
    public static void main(String[] args) {
        String input = "i.like.this.program.very.much";
        reverseString(input);
        reverseString("mno.pqr");
    }

    private static String reverseString(String input) {
        int i = 0;
        int j = input.length()-1;
        char[] charArr = input.toCharArray();
        while (i<j){
            char temp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = temp;
            i++;
            j--;
        }
        i = 0;
        j = 0;
        while (j != charArr.length){
            if(charArr[j] == '.' && j != i) {
                reverseWord(charArr, i, j-1);
                i = j+1;
            }
                j++;
        }
        if(i != j)
            reverseWord(charArr,i,j-1);
        System.out.println(String.valueOf(charArr));
        return null;
    }

    private static void reverseWord(char[] charArr, int i, int j) {
        while (i<j){
            char temp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = temp;
            i++;
            j--;
        }
    }
}
