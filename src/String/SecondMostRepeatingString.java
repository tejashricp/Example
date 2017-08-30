package String;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TPathrikar on 8/30/2017.
 */
public class SecondMostRepeatingString {

    public static void main(String[] args) throws IOException {
        String input = "aaa bbb ccc bbb aaa  aaa";
        System.out.println(getSecondMostRepeatedString(input));

    }

    public static String getSecondMostRepeatedString(String input){
        StringBuffer buffer = null;
        char[] charArr = input.toCharArray();
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (char c : charArr) {
            if(c != ' ') {
                if(buffer == null)
                    buffer = new StringBuffer();
                buffer.append(c);
            }
            else if(hashMap.containsKey(String.valueOf(buffer))){
                int count = hashMap.get(String.valueOf(buffer));
                hashMap.put(String.valueOf(buffer),count+1);
                buffer = null;
            }
            else if(buffer != null){
                hashMap.put(String.valueOf(buffer), 1);
                buffer = null;
            }
        }
        int max = Integer.MIN_VALUE;
        int secondMax = 0;
        String secondMaxStr = "";

        for (Map.Entry<String, Integer> stringIntegerEntry : hashMap.entrySet()) {
            if(stringIntegerEntry.getValue() > max) {
                max = stringIntegerEntry.getValue();
            }
            if(stringIntegerEntry.getValue()>=secondMax && stringIntegerEntry.getValue()<max) {
                secondMax = stringIntegerEntry.getValue();
                secondMaxStr = stringIntegerEntry.getKey();
            }
        }
        return secondMaxStr;
    }
}
