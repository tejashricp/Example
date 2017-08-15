package com.teja.multithreading.threadlocal;

/**
 * Created by TPathrikar on 7/18/2017.
 */
public class Test {
    static class Thread1 extends Thread{
        ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

        public void run(){
            integerThreadLocal.set((int)(Math.random()*100D));
            stringThreadLocal.set(this.toString());
            try {
                this.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(integerThreadLocal.get());
            System.out.println(stringThreadLocal.get());
        }
    }

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread1 thread12 = new Thread1();
        thread1.run();
        thread12.run();
    }

}
