package Java8.com.teja.defaultInterface;

/**
 * Created by TPathrikar on 3/30/2017.
 */

//abt default methods
/*extending interfaces : without having the fear of breaking implementation classes.
*bridge down the differences between interfaces and abstract classes.
*help in avoiding utility classes,
*help in removing base implementation classes,
*enhanced Collections API in Java 8 to support lambda expressions.
*If any class in the hierarchy has a method with same signature,
then default methods become irrelevant.
*A default method cannot override a method from java.lang.Object.
The reasoning is very simple, it’s because Object is the base class for all the java classes.
So even if we have Object class methods defined as default methods in interfaces, it will be useless because Object class method will always be used. That’s why to avoid confusion,
we can’t have default methods that are overriding Object class methods.Gives compilation error

*/

//abt static methods
    /*we can’t use it for implementation class objects.
*good for providing utility methods, for example null check, collection sorting etc.
*helps in providing security by not allowing implementation classes to override them.
*can’t define interface static method for Object class methods, we will get compiler error as “This static method cannot hide the instance method from Object”.
This is because it’s not allowed in java,
since Object is the base class for all the classes and we can’t have one class level static method and another instance method with same signature.
*We can use java interface static methods to remove utility classes such as Collections and move all of it’s static methods to the corresponding interface, that would be easy to find and use.*/


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

    //If any class in the hierarchy has a method with same signature,
    // then default methods become irrelevant.
    // A default method cannot override a method from java.lang.Object.
    // The reasoning is very simple, it’s because Object is the base class for all the java classes. So even if we have
    // Object class methods defined as default methods in interfaces, it will be useless because
    // Object class method will always be used. That’s why to avoid confusion,
    // we can’t have default methods that are overriding Object class methods.

    /*public default boolean equals(Object o){
       return true;
    }*/
}
