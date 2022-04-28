package uz.isystem.JobSeekers.employer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer> {

    Optional<Employer> findByIdAndDeletedAtIsNull(Integer id);

    List<Employer> findAllByDeletedAtIsNull();

}
