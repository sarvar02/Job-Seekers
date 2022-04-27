package uz.isystem.JobSeekers.work_time;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface WorkTimeMapper {

    @Mapping(target = "status" , ignore = true)
    @Mapping(target = "createdAt" , ignore = true)
    @Mapping(target = "deletedAt" , ignore = true)
    @Mapping(target = "updatedAt" , ignore = true)
    WorkTimeDto modelToDto(WorkTime workTime);

    @Mapping(target = "status" , ignore = true)
    @Mapping(target = "createdAt" , ignore = true)
    @Mapping(target = "deletedAt" , ignore = true)
    @Mapping(target = "updatedAt" , ignore = true)
    WorkTime dtoToModel(WorkTimeDto workTimeDto);
}
