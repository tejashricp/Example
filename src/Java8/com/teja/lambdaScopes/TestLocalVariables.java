package Java8.com.teja.lambdaScopes;

import com.teja.java8.functionalInterface.DummyFunctionInterface;

/**
 * Created by TPathrikar on 3/30/2017.
 */
public class TestLocalVariables {
    public static void main(String[] args) {
        //final local method variable is accessible
        final int num =2;
        DummyFunctionInterface<String,Integer> converter = (from)->String.valueOf(num+from);
        System.out.println(converter.convert(4));

        //non final method variable is also accessible , ths s different to anonymous classes
        int num1 = 2;
        DummyFunctionInterface<String,Integer> converter1 = (from)->String.valueOf(num1+from);
        System.out.println(converter1.convert(4));

        //non final method variable is also accessible , ths s different to anonymous classes
        //but following code gives compilation error, as variable used in lambda should be final or
        // effectively final
        int num3 = 3;
        //DummyFunctionInterface<String,Integer> converter2 = (from)->String.valueOf(num3+from);
        num3 = 8;
    }
}
