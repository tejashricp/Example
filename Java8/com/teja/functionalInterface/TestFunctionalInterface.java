package com.teja.java8.functionalInterface;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by TPathrikar on 3/30/2017.
 */
public class TestFunctionalInterface {

    public static void main(String[] args) {
        //here it s like we are giving method definition of single abstract methos
        DummyFunctionInterface<Integer,String>  converter = /*this is like incoming input parametr of method*/(from)->{
            /*body of abstract method*/
            System.out.println("In abstract method of functional interface");
            return Integer.valueOf(from);
        };
        Integer converted = converter.convert("121");
        System.out.println(converted);

        //using method  references. Here valurOf is static method of Integer which defines body of method
        DummyFunctionInterface<Integer,String> converter1 = Integer::valueOf;
        converted = converter1.convert("123");
        System.out.println(converted);

        //Java 8 enables you to pass references of methods or constructors via the :: keyword.
        Something something = new Something();
        DummyFunctionInterface<String,String> dummyFunctionInterface = something::startWith;
        String startingChar = dummyFunctionInterface.convert("java");
        System.out.println(startingChar);

        //using constructor as functional interface abstract method body
        //We create a reference to the Person constructor via Person::new.
        // The Java compiler automatically chooses the right constructor by matching the signature of
        PersonFactoryFunctionalInterface<Person> personFactory = Person::new;
        Person p = personFactory.create("teja","p");
        System.out.println(p.toString());
    }

}
class Person{
    String fname;
    String lname;

    public Person(String fname) {
        this.fname = fname;
    }

    public Person() {
    }

    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    @Override
    public String toString() {
        return fname+" " +lname;
    }
}

class Something{
    String startWith(String s){
        return String.valueOf(s.charAt(0));
    }
}
