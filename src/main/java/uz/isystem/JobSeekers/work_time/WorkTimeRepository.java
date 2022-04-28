package uz.isystem.JobSeekers.work_time;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.util.MimeType;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkTimeRepository extends JpaRepository<WorkTime, Integer>, JpaSpecificationExecutor<WorkTime> {

    Optional<WorkTime> findByIdAndDeletedAtIsNull(Integer id);

    List<WorkTime> findAllByDeletedAtIsNull();

}
