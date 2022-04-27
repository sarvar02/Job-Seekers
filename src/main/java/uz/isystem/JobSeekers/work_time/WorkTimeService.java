package uz.isystem.JobSeekers.work_time;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.isystem.JobSeekers.exception.ServerBadRequestException;

import javax.swing.text.html.Option;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class WorkTimeService {

    private final WorkTimeRepository workTimeRepository;
    private final WorkTimeMapper workTimeMapper;

    public WorkTime getEntity(Integer id){
        return  workTimeRepository.findById(id)
                .orElseThrow(() -> new ServerBadRequestException("Work time not found !"));
    }

}
