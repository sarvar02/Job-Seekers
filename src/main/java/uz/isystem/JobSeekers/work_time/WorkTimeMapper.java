package uz.isystem.JobSeekers.work_time;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface WorkTimeMapper {

    WorkTimeDto modelToDto(WorkTime workTime);

    WorkTime dtoToModel(WorkTimeDto workTimeDto);
}
