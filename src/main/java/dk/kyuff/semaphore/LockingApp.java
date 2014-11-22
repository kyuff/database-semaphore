package dk.kyuff.semaphore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * User: swi
 * Date: 22/11/14
 * Time: 19.12
 */
public abstract class LockingApp {

    EntityManagerFactory emf;
    EntityManager entityManager;

    public LockingApp() {
        this.emf = Persistence.createEntityManagerFactory("semaphore");
        this.entityManager = emf.createEntityManager();
    }

    public final void start() {
        entityManager.getTransaction().begin();
        doStart();
    }

    public final void stop() {
        doStop();
        if( !entityManager.getTransaction().getRollbackOnly() ) {
            entityManager.getTransaction().commit();
        }
        entityManager.close();
        emf.close();
    }

    protected abstract void doStop();

    protected abstract void doStart();

    public Mutex createMutex() {
        return new Mutex(entityManager);
    }
}
