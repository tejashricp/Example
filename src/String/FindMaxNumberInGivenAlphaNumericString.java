import java.util.ArrayList;
import java.util.List;

/**
 Given an alphanumeric string,
 extract maximum numeric value from that string.
 Alphabets will only be in lower case. Examples:

 Input : 100klh564abc365bg Output : 564
 Maximum numeric value among 100, 564 and 365 is 564.
 */
public class FindMaxNumberInGivenAlphaNumericString{

    public static void main(String[] args) {
        String input = "100klh5640abc36513bg";
        int op = getMaxNumericValue(input);
        System.out.println(op);
    }

    private static int getMaxNumericValue(String input) {
        char[] arr = input.toCharArray();
        int i = 0;
        int max = Integer.MIN_VALUE;
        StringBuffer sb = new StringBuffer("");
        while (i<arr.length){
            if(arr[i] >= 48 && arr[i]<=57){
                sb.append(arr[i]);
                int curr = Integer.parseInt(sb.toString());
                if(max<curr)
                    max = curr;
            }
            else {
               if(sb.length() != 0)
                sb = new StringBuffer("");
            }
            i++;
        }

        return max;
    }


}


