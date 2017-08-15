import java.util.Arrays;
import java.util.Collections;

/*
Given a string of words with lots of spaces between the words , remove all the unnecessary spaces like
        input:  I   live   on     earth
        output: I live on earth
*/
public class Test {
    public static void main(String[] args) {
        String input="  I   live   on     earth";
        removeExtraSpaces(input);
        String input1="  I   live   on     earth  ";
        removeExtraSpaces(input1);
        String input2="   ";
        removeExtraSpaces(input2);
        String input3="";
        removeExtraSpaces(input3);
    }

    private static void removeExtraSpaces(String input) {
        boolean addSpace = false;
        char[] chars = input.toCharArray();
        StringBuffer out=new StringBuffer("");
        int i = 0;
        while(i<chars.length){
            if(addSpace)
                out.append(' ');

            if(chars[i] != ' ') {
                out.append(chars[i]);
                addSpace = false;
            }
            if(chars[i] == ' ' ){
                if(i+1<chars.length && chars[i+1] != ' ')
                    addSpace = true;
                else
                    addSpace = false;
            }
            i++;
        }
        System.out.println(out);
    }
}
