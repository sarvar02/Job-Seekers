package uz.isystem.JobSeekers.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query("select c from countries c where c.deletedAt is null")
    List<Country> findAllAndDeletedAtIsNull();

    @Query("select c from countries c where c.id = ?1 and c.deletedAt is null")
    Optional<Country> findByIdAndDeletedAtIsNull(Integer id);
}
