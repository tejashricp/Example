package java_custom;

import java.util.LinkedList;

/**
 * Created by TPathrikar on 9/1/2017.
 */
class MainClass{
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer(3);
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producerThread.start();
        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        consumerThread.start();
        producerThread.join();
        consumerThread.join();
    }
}

public class ProducerConsumer {
    int capacity;
    LinkedList<Integer> linkedList;
    int value = 0;

    public ProducerConsumer(int capacity) {
        this.capacity = capacity;
        this.linkedList = new LinkedList();
    }

    public void produce() throws InterruptedException {

        while (true){
            synchronized (this){
                while (linkedList.size() == capacity)
                    wait();
                System.out.println("producing val "+value);
                linkedList.add(value++);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true){
            synchronized (this){
                while (linkedList.size() == 0)
                    wait();
                System.out.println("consuming val "+linkedList.removeFirst());
                notify();
                Thread.sleep(1000);
            }
        }
    }
}
