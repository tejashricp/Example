package Java8.com.teja.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by TPathrikar on 3/30/2017.
 */
public class SortList {

    public static void main(String[] args) {
        //older way of sorting list
        List<String> stringList = Arrays.asList("teja","pooja","diptee","nano","sarika");
        Collections.sort(stringList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (String s : stringList) {
            System.out.print(s+" ");
        }
        List<String> stringList1 = Arrays.asList("teja","pooja","diptee","nano","sarika");

        //with ne lambda expression
        Collections.sort(stringList1,(a,b)-> b.compareTo(a));
        for (String s : stringList) {
            System.out.print(s+" ");
        }
    }
}
