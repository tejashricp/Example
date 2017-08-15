package com.teja.multithreading.wait_notify;

/**
 * Created by TPathrikar on 7/19/2017.
 */
public class TestWaitNotify {

class MyTest{
    MyMonitorObj myMonitorObj = new MyMonitorObj();

    //wait and notify must be called from sync block
    //else illegal monitor state exception is thrown

    public void doWait(){
        synchronized (myMonitorObj) {
            try {
                myMonitorObj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void doNotify(){
        synchronized (myMonitorObj) {
            myMonitorObj.notify();
        }
    }

}
    public class MyMonitorObj {
    }

}
