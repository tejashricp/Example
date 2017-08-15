package multithreading.deadlock;

/**
 * Created by TPathrikar on 7/22/2017.
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Thread t1 = new Thread(new TestThread(a, b), "t1");
        Thread t2 = new Thread(new TestThread(b,c),"t2");
        Thread t3 = new Thread (new TestThread(c,a),"t3");
        t1.start();
        Thread.sleep(3000);
        t2.start();
        Thread.sleep(3000);
        t3.start();
    }
}
    class TestThread extends Thread{
        Integer a;
        Integer b;

        public TestThread(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }

        public void run(){
            System.out.println("Inside thread "+this.getName());
            System.out.println("Acquiring lock on integer a = "+a);
            synchronized (a){
                System.out.println("Acquired lock on integer a = "+a);
                try {
                    this.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Acquiring lock on integer b = "+b);
                synchronized (b){
                    System.out.println("Acquired lock on integer b = "+b);
                    doSomeWork();
                }
                System.out.println("Released lock on integer b = "+b);
            }
            System.out.println("Released lock on integer a = "+a);
            System.out.println("Finished work for thread "+this.getName());
        }

        private void doSomeWork() {
            System.out.println("Work done on a "+a+" and b "+b);
            try {
                this.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

