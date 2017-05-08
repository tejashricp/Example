package com.teja.java8.defaultinterface;

/**
 * Created by TPathrikar on 3/30/2017.
 */
public class MainTestClass {

    public static void main(String[] args) {
        DummyDefInterface dummyDefInterface = new DefInterfaceImplementor();
        //calling default method in interface
        //results in calling overridden method of class and not the interface
        //if nothing is overridden def function in interface in getting called
        dummyDefInterface.getAddress();
        //calling abstract method in interface
        //calls implemented method
        dummyDefInterface.getValue();
        //calling static method in interface
        DummyDefInterface.getName();
    }
}