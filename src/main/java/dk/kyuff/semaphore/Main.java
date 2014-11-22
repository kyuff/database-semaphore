package dk.kyuff.semaphore;

import javax.persistence.Persistence;

/**
 * User: swi
 * Date: 22/11/14
 * Time: 08.00
 */
public class Main {

    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("semaphore");
    }
}
