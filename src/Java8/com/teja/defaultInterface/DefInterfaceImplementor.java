package Java8.com.teja.defaultInterface;

/**
 * Created by TPathrikar on 3/30/2017.
 */
public class DefInterfaceImplementor implements DummyDefInterface,DummyDefInterface1 {
    @Override
    public void getValue() {
        System.out.println("implementing abstract method in interface");
    }

    //Because if a class is implementing both Interface1 and Interface2 and
    // doesn’t implement the common default method,
    // compiler can’t decide which one to chose.
    //it’s made mandatory to provide implementation for common default methods of interfaces.
    @Override
    public void getAddress() {
        System.out.println("overriding default method in interface and interface1 as it is mandatory now");
    }

    //overridden default method in interface
    //making it different from default method for testing
    public void getAddress1(){
        System.out.println("changed name of overriding default method in interface");
    }


}
