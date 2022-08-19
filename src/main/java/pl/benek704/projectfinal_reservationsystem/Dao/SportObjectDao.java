package pl.benek704.projectfinal_reservationsystem.Dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import pl.benek704.projectfinal_reservationsystem.model.Club;
import pl.benek704.projectfinal_reservationsystem.model.SportObject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class SportObjectDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void safeSportObject(SportObject sportObject) {
        entityManager.persist(sportObject);
    }

    public List<SportObject> findAllSportsObjectsByClub(Long id) {
        return entityManager
                .createQuery("select b from SportObject b where b.club.id=:cid", SportObject.class)
                .setParameter("cid", id)
                .getResultList();
    }

    public SportObject findById(Long id) {
        return entityManager.find(SportObject.class, id);
    }

    public void delete(SportObject sportObject) {
        entityManager.remove(entityManager.contains(sportObject) ?
                sportObject : entityManager.merge(sportObject));
    }

}
