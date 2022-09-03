package uz.isystem.JobSeekers.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Query("select s from subjects s where s.deletedAt is null")
    List<Subject> findAllByDeletedAtIsNull();

    @Query("select s from subjects s where s.id = ?1 and s.deletedAt is null")
    Optional<Subject> findByIdAndDeletedAtIsNull(Long id);
}
