package java_custom;

/**
 * Created by TPathrikar on 10/1/2017.
 */
public class AbstarctClassTest {
    public static void main(String[] args) {
        Demo.test();

    }
}

abstract class Demo{
    public Demo(int a){
        System.out.println("value of a "+a);
    }

    //abstract public Demo();//cant declare constructor as abstract
    //abstract public static void test1();//cant declare static abstarct method
    abstract public void show();

    public static void test(){
        System.out.println("in static method of abstract class");
    }
}