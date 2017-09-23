package java_custom;

/**
 * Created by TPathrikar on 9/19/2017.
 */

public class PrintPattern {
    public static void main(String[] args) throws InterruptedException {
        PatternPrinter patternPrinter = new PatternPrinter();
        Thread zeroThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    patternPrinter.printZero();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread oddThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    patternPrinter.printNum();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread evenThread = new Thread(new Runnable() {
            int val = 0;
            @Override
            public void run() {
                try {
                    patternPrinter.printNum();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        zeroThread.start();
        oddThread.start();
        evenThread.start();

        zeroThread.join();
        oddThread.join();
        evenThread.join();
    }
}

class PatternPrinter{
    int zero = 0;
    int num = 1;
    boolean printNum = false;

    public void printZero() throws InterruptedException {
        while (true) {
            synchronized (this){
                Thread.sleep(1000);
                System.out.print(zero);
                printNum = true;
                this.notify();
                this.wait();
            }
        }
    }

    public void printNum() throws InterruptedException {
        while (true) {
            synchronized (this){
                if(printNum){
                    Thread.sleep(1000);
                    System.out.print(num++);
                    this.notify();
                }
                this.wait();
            }
        }
    }
}
