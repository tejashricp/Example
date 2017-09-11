package multithreading.slippedcondition;

/**
 * Created by TPathrikar on 9/7/2017.
 */

//this is demo of slipped condition
/*
* This situation is an example of slipped conditions.
* Both threads test the condition, then exit the synchronized block,
* thereby allowing other threads to test the condition,
* before any of the two first threads change the conditions for subsequent threads.
* In other words, the condition has slipped from the time the condition was checked
* until the threads change it for subsequent threads.
* To avoid slipped conditions the testing and setting of the conditions must be done atomically
* by the thread doing it, meaning that no other thread can check the condition in between the testing
* and setting of the condition by the first thread.
* */
public class Lock {
    private boolean isLocked = true;

    public void lock(){
        synchronized (this){
            while (isLocked){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                }
            }
        }
        synchronized (this){
            isLocked = true;
        }
    }

    public synchronized void  unlock(){
            isLocked = false;
            this.notify();
    }
}
