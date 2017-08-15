package multithreading.wait_notify;

/**
 * Created by TPathrikar on 7/19/2017.
 */
public class MissedSignals {
    MonitorObject myMonitorObject = new MonitorObject();
    boolean wasSignalled = false;

    //use notify signal to avoid missed signal issue in waiting
    public void doWait(){
        synchronized(myMonitorObject){
            if(!wasSignalled){
                try{
                    myMonitorObject.wait();
                } catch(InterruptedException e){

                }
            }
            //clear signal and continue running.
            wasSignalled = false;
        }
    }

    //capture notify siganl in variable to avoid missed notify calls
    public void doNotify(){
        synchronized(myMonitorObject){
            wasSignalled = true;
            myMonitorObject.notify();
        }
    }
    class MonitorObject {
    }

}
