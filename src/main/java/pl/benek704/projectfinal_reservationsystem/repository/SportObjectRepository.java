package pl.benek704.projectfinal_reservationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.benek704.projectfinal_reservationsystem.model.SportObject;

@Repository
public interface SportObjectRepository extends JpaRepository<SportObject, Long> {

}
