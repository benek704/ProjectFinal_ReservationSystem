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
public class ClubDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Club> findAllClubs() {
        return entityManager.
                createQuery("select b from Club b", Club.class)
                .getResultList();
    }

    public List<Club> findAllClubsBySport(Long sport) {
        return entityManager
                .createQuery("select b from Club b where b.sport.id=:sp", Club.class)
                .setParameter("sp", sport)
                .getResultList();
    }

    public List<Club> findAllClubsByCity(String city) {
        return entityManager
                .createQuery("select b from Club b where b.city=:cit", Club.class)
                .setParameter("cit", city)
                .getResultList();
    }

    public void safeClub(Club club) {
        entityManager.persist(club);
    }

    public Club findById(Long id) {
        return entityManager.find(Club.class, id);
    }

    public void delete(Club club) {
        entityManager.remove(entityManager.contains(club) ?
                club : entityManager.merge(club));
    }


}
