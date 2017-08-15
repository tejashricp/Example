package com.teja.multithreading.synchronize;

/**
 * Created by TPathrikar on 7/16/2017.
 */
/*Two threads are created.
The same Counter instance is passed to both of them in their constructor.
The Counter.add() method is synchronized on the instance,
because the add method is an instance method, and marked as synchronized.
Therefore only one of the threads can call the add() method at a time.
The other thread will wait
until the first thread leaves the add() method,
before it can execute the method itself.*/
/*If the two threads had referenced two separate Counter instances,
there would have been no problems calling the add() methods simultaneously.*/
public class Test {

    public static void main(String[] args) {
        Counter counter = new Counter(3);
        Thread thread1 = new CounterThread1(counter);
        Thread thread2 = new CounterThread2(counter);
        thread1.start();
        thread2.start();

    }
static class CounterThread1 extends Thread{
    Counter counter;
    public CounterThread1(Counter counter) {
        super();
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++) {
            System.out.println("thread 1 acquiring lock");
            counter.add();
            System.out.println("thread 1 done job");
        }
    }
}

static class CounterThread2 extends Thread{
    Counter counter;
    public CounterThread2(Counter counter) {
        super();
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++) {
            System.out.println("thread 2 acquiring lock");
            counter.add();
            System.out.println("thread 2 done job");
        }
    }
}

static class Counter{
    private int count;

    Counter(int count) {
        this.count = count;
    }

    public synchronized void add(){
        this.count++;
    }
}

}
