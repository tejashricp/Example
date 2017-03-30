package com.teja.java8.functionalInterface;

/**
 * Created by TPathrikar on 3/30/2017.
 */
@FunctionalInterface
public interface PersonFactoryFunctionalInterface<P> {

    P create(String fname, String lname);
}
