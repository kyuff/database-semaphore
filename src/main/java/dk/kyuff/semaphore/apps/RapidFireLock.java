package dk.kyuff.semaphore.apps;

import dk.kyuff.semaphore.LockingApp;
import dk.kyuff.semaphore.Mutex;
import dk.kyuff.semaphore.Sleeper;

import static dk.kyuff.semaphore.Semaphore.*;

/**
 * User: swi
 * Date: 22/11/14
 * Time: 22.03
 */
public class RapidFireLock extends LockingApp {

    public static void main(String[] args) {
        LockingApp app = new RapidFireLock();
        app.start();
        app.stop();
    }

    @Override
    protected void doStart() {

        Mutex mutex = createMutex();

        System.out.println("Starting " + RapidFireLock.class.getSimpleName());
        mutex.lock(BUSINESS, new Sleeper(BUSINESS, 1), status -> BUSINESS + " failed");
        mutex.lock(BLACKOPS, new Sleeper(BLACKOPS, 1), status -> BLACKOPS + " failed");
        mutex.lock(BUSINESS, new Sleeper(BUSINESS, 1), status -> BUSINESS + " failed");
        mutex.lock(BLACKOPS, new Sleeper(BLACKOPS, 1), status -> BLACKOPS + " failed");
        mutex.lock(BUSINESS, new Sleeper(BUSINESS, 1), status -> BUSINESS + " failed");
        mutex.lock(BLACKOPS, new Sleeper(BLACKOPS, 1), status -> BLACKOPS + " failed");
    }

    @Override
    protected void doStop() {

    }
}
