package pl.benek704.projectfinal_reservationsystem.Dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.benek704.projectfinal_reservationsystem.model.Club;
import pl.benek704.projectfinal_reservationsystem.model.Sport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class SportDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Sport> findAllSports() {
        return entityManager
                .createQuery("select b from Sport b", Sport.class)
                .getResultList();
    }

    public Sport findSportByName(String name) {
        return entityManager
                .createQuery("select b from Sport b where b.name=:spo", Sport.class)
                .setParameter("spo", name)
                .getSingleResult();
    }

    public Sport findSportById(long id) {
        return entityManager.find(Sport.class, id);
    }

}
