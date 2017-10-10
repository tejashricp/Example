package java_custom;

import Java8.com.teja.defaultInterface.DummyDefInterface;

/**
 * Created by TPathrikar on 9/29/2017.
 */
public class InheritanceTest {
    int i = 10;
    int j =15;

    public int getI(){
        return i;
    }

    public int getJ(){
        return j;
    }
}

class Subclass extends InheritanceTest implements DummyDefInterface {
    int k =20;
    public int getK(){
        return k;
    }

    @Override
    public void getValue() {

    }

    //default methods in interface can also be implemented by non package class
    //as default is not access specifier here, but it is symbolic representation of default method
    @Override
    public void getAddress() {

    }
}

class MainTest{
    public static void main(String[] args) {
        InheritanceTest inheritanceTest = new InheritanceTest();
        Subclass subclass = new Subclass();
        inheritanceTest.getI();
        inheritanceTest.getJ();
        subclass.getI();
        subclass.getJ();
        subclass.getK();
        inheritanceTest = subclass;
        inheritanceTest.getI();
        inheritanceTest.getJ();
        //inheritanceTest.getK();//this gives compilation error as doesnt have getk method reference in superclass
        ((Subclass)inheritanceTest).getK();//and this works fine
    }
}