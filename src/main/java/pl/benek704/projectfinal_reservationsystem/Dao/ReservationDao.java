package pl.benek704.projectfinal_reservationsystem.Dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.benek704.projectfinal_reservationsystem.model.Club;
import pl.benek704.projectfinal_reservationsystem.model.Reservation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ReservationDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void addReservation(Reservation reservation) {
        entityManager.persist(reservation);
    }

    public Reservation findById(Long id) {
        return entityManager.find(Reservation.class, id);
    }

    public void delete(Reservation reservation) {
        entityManager.remove(entityManager.contains(reservation) ?
                reservation : entityManager.merge(reservation));
    }
}
