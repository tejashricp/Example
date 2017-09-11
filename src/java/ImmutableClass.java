package java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TPathrikar on 9/10/2017.
 */

/*
* Make data items private
* Do not give setters
* clone member variables in getter
*
* */
public final class ImmutableClass {
    private final int data;
    private  final String str;
    private final HashMap<Integer,String> hashMap = new HashMap<>();

    public ImmutableClass(int data, String str, HashMap<Integer, String> hashMap) {
        this.data = data;
        this.str = str;
        for (Map.Entry<Integer, String> integerStringEntry : hashMap.entrySet()) {
            this.hashMap.put(integerStringEntry.getKey(),integerStringEntry.getValue());
        }
    }

    public int getData() {
        return data;
    }

    public String getStr() {
        return str;
    }

    public HashMap<Integer, String> getHashMap() {
        return (HashMap<Integer, String>) hashMap.clone();
    }
}
