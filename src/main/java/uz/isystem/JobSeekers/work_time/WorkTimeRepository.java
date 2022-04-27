package uz.isystem.JobSeekers.work_time;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.util.MimeType;

@Repository
public interface WorkTimeRepository extends JpaRepository<WorkTime, Integer>, JpaSpecificationExecutor<WorkTime> {

}
