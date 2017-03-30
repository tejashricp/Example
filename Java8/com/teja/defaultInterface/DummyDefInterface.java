package com.teja.java8.defaultinterface;

/**
 * Created by TPathrikar on 3/30/2017.
 */
public interface DummyDefInterface {
    //static methoda should have body in interface
    public static void getName(){
        System.out.println("getting name");
    }
    //abstract method in interface
    public void getValue();

    //default method as per java8
    public default void getAddress(){
        System.out.println("default method of inetrface");
    }
}
