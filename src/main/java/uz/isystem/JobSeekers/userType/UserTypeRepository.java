package uz.isystem.JobSeekers.userType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
    @Query("select u from user_types u where u.id = ?1 and u.deletedAt is null")
    Optional<UserType> findByIdAndDeletedAtIsNull(Integer id);

    @Query("select u from user_types u where u.deletedAt is null")
    List<UserType> findAllAndDeletedAtIsNull();
}
