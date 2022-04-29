package uz.isystem.JobSeekers.user;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "status" , ignore = true)
    @Mapping(target = "createdAt" , ignore = true)
    @Mapping(target = "deletedAt" , ignore = true)
    @Mapping(target = "updatedAt" , ignore = true)
    @Mapping(target = "id" , ignore = true)
    User dtoToModel(UserDto userDto);

    @Mapping(target = "status" , ignore = true)
    @Mapping(target = "createdAt" , ignore = true)
    @Mapping(target = "deletedAt" , ignore = true)
    @Mapping(target = "updatedAt" , ignore = true)
    UserDto modelToDto(User user);

}
