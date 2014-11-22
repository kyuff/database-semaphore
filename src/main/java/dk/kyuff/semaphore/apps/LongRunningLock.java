package dk.kyuff.semaphore.apps;

import dk.kyuff.semaphore.LockingApp;
import dk.kyuff.semaphore.Mutex;
import dk.kyuff.semaphore.Sleeper;

import static dk.kyuff.semaphore.Semaphore.*;
/**
 * User: swi
 * Date: 22/11/14
 * Time: 08.00
 */
public class LongRunningLock extends LockingApp {


    public static void main(String[] args) {
        LockingApp app = new LongRunningLock();
        app.start();
        app.stop();
    }

    @Override
    protected void doStart() {
        Mutex mutex = createMutex();

        System.out.println("Starting " + LongRunningLock.class.getSimpleName());
        mutex.lock(BLACKOPS, new Sleeper(BLACKOPS, 20), status -> BLACKOPS + " failed");

    }

    @Override
    protected void doStop() {

    }

}
