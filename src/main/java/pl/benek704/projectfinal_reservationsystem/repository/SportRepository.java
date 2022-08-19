package pl.benek704.projectfinal_reservationsystem.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.benek704.projectfinal_reservationsystem.model.Sport;

import java.util.List;

@Repository
public interface SportRepository extends JpaRepository<Sport, Long> {
    @Override
    List<Sport> findAll(Sort sort);

}
