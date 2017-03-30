package com.teja.java8.functionalInterface;

/**
 * Created by TPathrikar on 3/30/2017.
 */
//functional interface is one which has only one abstract method
//it can have one or more default methods and static methods

@FunctionalInterface
public interface DummyFunctionInterface<T,F> {

    public T convert(F from);

    public default void getInterfaceName(){
        System.out.println("i m in dummy functional interface");
    }

    public default void getName(){
        System.out.println("i m student");
    }

    public static void getValue(){
        System.out.println("value is 0");
    }

}
