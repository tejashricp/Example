package java_custom;

/**
 * Created by TPathrikar on 9/29/2017.
 */

/*
*
* There are two types of nested classes: static and non-static. A static nested class is one
that has the static modifier applied. Because it is static, it must access the non-static members
of its enclosing class through an object. That is, it cannot refer to non-static members of its
enclosing class directly. Because of this restriction, static nested classes are seldom used.
* Inner class can know outer class variables but outer class cannot without instance of inner class
*
* */
public class InnerClass {
    int x =10;
    private  int y =1;
    private static int z =20;
    public void testOuter()
    {
        InnerTest innerTest = new InnerTest();
        InnerTest2 innerTest2 = new InnerTest2();

    }

    class InnerTest{
        public void test(){
            System.out.println(x+" "+y+" "+z);
            testOuter();
        }
    }

    static class InnerTest2{
        public void test(){
            System.out.println(new InnerClass().x+" "+new InnerClass().y+" "+z);
        }

        public static void test1(){
            System.out.println("test");
        }
    }
}

class Main{
    public void test(){
        //non static class cant be instantiated out of its outer class
        //InnerClass.InnerTest innerTest = new InnerClass.InnerTest();
        //while static class can be instantiated
        InnerClass.InnerTest2 innerTest2 = new InnerClass.InnerTest2();
        InnerClass.InnerTest2.test1();
        innerTest2.test();
    }
}