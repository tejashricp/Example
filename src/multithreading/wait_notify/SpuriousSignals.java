package multithreading.wait_notify;

/**
 * Created by TPathrikar on 7/19/2017.
 */
public class SpuriousSignals {

    MonitorObject myMonitorObject = new MonitorObject();
    boolean wasSignalled = false;

    /*To guard against spurious wakeups the signal
    member variable is checked inside a while loop
    instead of inside an if-statement.
    Such a while loop is also called a spin lock.
    The thread awakened spins around until the condition in the spin lock
    (while loop) becomes false. */

    public void doWait(){
        synchronized(myMonitorObject){
            while(!wasSignalled){
                try{
                    myMonitorObject.wait();
                } catch(InterruptedException e){

                }
            }
            //clear signal and continue running.
            wasSignalled = false;
        }
    }

    public void doNotify(){
        synchronized(myMonitorObject){
            wasSignalled = true;
            myMonitorObject.notify();
        }
    }
    class MonitorObject {
    }

}
