package com.teja.java8.defaultinterface;

/**
 * Created by TPathrikar on 3/30/2017.
 */
public interface DummyDefInterface1 {

    public default void getAddress(){
        System.out.println("get address in interface1");
    }
}
