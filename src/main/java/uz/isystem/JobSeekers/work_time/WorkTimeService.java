package uz.isystem.JobSeekers.work_time;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.isystem.JobSeekers.exception.ServerBadRequestException;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WorkTimeService {

    private final WorkTimeRepository workTimeRepository;
    private final WorkTimeMapper workTimeMapper;

//    Get One By Id

    public WorkTimeDto getWorkTimeById(Integer id){
        return workTimeMapper.modelToDto(getEntity(id));
    }

//    Create Work time

    public void createWorkTime(WorkTimeDto workTimeDto){
        WorkTime workTime = workTimeMapper.dtoToModel(workTimeDto);
        workTime.setStatus(true);
        workTime.setCreatedAt(LocalDateTime.now());
        workTimeRepository.save(workTime);
    }

//    Get All Work Times

    public List<WorkTimeDto> getAllWorkTimes(){
        List<WorkTime> workTimeList = workTimeRepository.findAllByDeletedAtIsNull();
        if(workTimeList.isEmpty()){
            throw new ServerBadRequestException("Work time not found !");
        }
        return workTimeList.stream()
                .map(workTime -> workTimeMapper.modelToDto(workTime))
                .collect(Collectors.toList());
    }

//    Update Work Time

    public void updateWorkTime(Integer id, WorkTimeDto workTimeDto){
        WorkTime workTime = getEntity(id);
        workTime.setUpdatedAt(LocalDateTime.now());
        workTime.setName(workTimeDto.getName());
        workTimeRepository.save(workTime);
    }


//    Delete Work Time

    public void deleteWorkTime(Integer id){
        WorkTime workTime = getEntity(id);
        workTime.setDeletedAt(LocalDateTime.now());
        workTimeRepository.save(workTime);
    }


    public WorkTime getEntity(Integer id){
        return  workTimeRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ServerBadRequestException("Work time not found !"));
    }

}
