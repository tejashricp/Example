package com.teja.java8.defaultinterface;

/**
 * Created by TPathrikar on 3/30/2017.
 */
public class DefInterfaceImplementor implements DummyDefInterface {
    @Override
    public void getValue() {
        System.out.println("implementing abstract method in interface");
    }

    //overridden default method in interface
    //making it different from default method for testing
    public void getAddress1(){
        System.out.println("overriding default method in interface");
    }
}
