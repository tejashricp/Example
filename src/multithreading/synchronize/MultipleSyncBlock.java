package multithreading.synchronize;

/**
 * Created by TPathrikar on 7/16/2017.
 */
/*
* Only one thread acquires lock if same monitor object in synchronized in multiple blocks
*
*
* */
public class MultipleSyncBlock {
    public static void main(String[] args) throws InterruptedException {
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
                counter.subtract();
                System.out.println("thread 1 done job");
                try {
                    this.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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

        public void add(){
            synchronized ((Integer)count){
                count = count-1;
            }
        }

        public void subtract(){
            synchronized ((Integer)count){
                count = count-1;
            }
        }
    }

}
