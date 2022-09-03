package uz.isystem.JobSeekers.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByIdAndDeletedAtIsNull(Integer id);

    User findByUsername(String username);

    List<User> findAllByDeletedAtIsNull();

}
