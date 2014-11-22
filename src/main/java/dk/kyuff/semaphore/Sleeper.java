package dk.kyuff.semaphore;

import java.util.function.Function;

import static dk.kyuff.semaphore.Semaphore.BUSINESS;

/**
 * User: swi
 * Date: 22/11/14
 * Time: 22.09
 */
public class Sleeper implements Function<Boolean, String> {

    private Semaphore semaphore;
    private int seconds;

    public Sleeper(Semaphore semaphore, int seconds) {
        this.semaphore = semaphore;
        this.seconds = seconds;
    }

    @Override
    public String apply(Boolean aBoolean) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return semaphore + " is done";
    }
}
