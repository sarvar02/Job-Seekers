package uz.isystem.JobSeekers.employer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface EmployerMapper {

    @Mapping(target = "status" , ignore = true)
    @Mapping(target = "createdAt" , ignore = true)
    @Mapping(target = "deletedAt" , ignore = true)
    @Mapping(target = "updatedAt" , ignore = true)
    @Mapping(target = "id" , ignore = true)
    Employer dtoToModel(EmployerDto employerDto);

    @Mapping(target = "status" , ignore = true)
    @Mapping(target = "createdAt" , ignore = true)
    @Mapping(target = "deletedAt" , ignore = true)
    @Mapping(target = "updatedAt" , ignore = true)
    EmployerDto modelToDto(Employer employer);

}
