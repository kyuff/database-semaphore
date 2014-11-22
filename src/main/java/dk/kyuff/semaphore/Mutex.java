package dk.kyuff.semaphore;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceException;
import javax.persistence.PessimisticLockException;
import java.util.Random;
import java.util.function.Function;

/**
 * User: swi
 * Date: 22/11/14
 * Time: 20.58
 */
public class Mutex {

    private EntityManager entityManager;

    private final Random random = new Random();

    public Mutex(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void lock(Semaphore semaphore, Function<Boolean, String> success, Function<Boolean, String> failure) {
        try {
            entityManager.find(SemaphoreEntity.class, semaphore, LockModeType.PESSIMISTIC_WRITE);
            String output = success.apply(true);
            System.out.println(output);
        } catch (PersistenceException e) {
            String output = failure.apply(false);
            System.out.println(output + " could not get a lock");
        }
    }
}
