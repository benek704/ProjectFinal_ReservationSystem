package pl.benek704.projectfinal_reservationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.benek704.projectfinal_reservationsystem.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
