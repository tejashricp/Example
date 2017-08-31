package String;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by TPathrikar on 8/31/2017.
 */

/*Given a positive integer,
return its corresponding column title as appear in an Excel sheet.
MS Excel columns has a pattern like A, B, C, … ,Z, AA, AB, AC,…. ,AZ, BA, BB, … ZZ, AAA, AAB ….. etc.
In other words, column 1 is named as “A”, column 2 as “B”, column 27 as “AA”.
*/
public class ColumnNameFromColumnNumber {

    public static void main(String[] args) {
        int input = 81;
        System.out.println(getColumnName(input));
    }

    public static char[] charArr = {' ','A','B','C','D','E','F','G','H','I','J','K','L','M',
                        'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    private static String getColumnName(int input) {
        StringBuffer out = new StringBuffer();
        int remainder = input;
        int quotient = -1;
        while (remainder >= 0 && remainder > 26){
            quotient = remainder/26;
            remainder = remainder%26;
            if(remainder != 0)
                out.append(charArr[quotient]);
            else {
                out.append(charArr[1]);
                remainder = 26;
            }
        }
        out.append(charArr[remainder]);
        return String.valueOf(out);
    }
}
