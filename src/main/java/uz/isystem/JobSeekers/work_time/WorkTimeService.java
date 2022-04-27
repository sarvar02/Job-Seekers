package uz.isystem.JobSeekers.work_time;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.isystem.JobSeekers.exception.ServerBadRequestException;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class WorkTimeService {

    private final WorkTimeRepository workTimeRepository;
    private final WorkTimeMapper workTimeMapper;

    public WorkTimeDto getWorkTime(Integer id){
        return workTimeMapper.modelToDto(getEntity(id));
    }

    public void createWorkTime(WorkTimeDto workTimeDto){
        WorkTime workTime = workTimeMapper.dtoToModel(workTimeDto);
        workTime.setStatus(true);
        workTime.setCreatedAt(LocalDateTime.now());
        workTimeRepository.save(workTime);
    }

    public WorkTime getEntity(Integer id){
        return  workTimeRepository.findById(id)
                .orElseThrow(() -> new ServerBadRequestException("Work time not found !"));
    }

}
