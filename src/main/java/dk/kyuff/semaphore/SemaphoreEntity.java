package dk.kyuff.semaphore;

import javax.persistence.*;

/**
 * User: swi
 * Date: 22/11/14
 * Time: 19.13
 */
@Entity
@Table(name = "semaphore")
public class SemaphoreEntity {

    @Id
    @Enumerated(EnumType.STRING)
    Semaphore id;

    Long version;

    public Semaphore getId() {
        return id;
    }

    public void setId(Semaphore id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
