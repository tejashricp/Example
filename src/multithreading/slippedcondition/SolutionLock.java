package multithreading.slippedcondition;

/**
 * Created by TPathrikar on 9/7/2017.
 */

/*
* Now the testing and setting of the isLocked condition is done atomically from inside the same synchronized block.
* */
public class SolutionLock {
    private boolean isLocked = true;

    public void lock(){
        synchronized (this){
            while (isLocked){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isLocked = true;
        }
    }

    public synchronized void unlock(){
        isLocked = false;
        this.notify();
    }


}
