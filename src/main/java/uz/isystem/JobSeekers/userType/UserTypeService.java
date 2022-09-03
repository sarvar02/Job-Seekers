package uz.isystem.JobSeekers.userType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.isystem.JobSeekers.exception.ServerBadRequestException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserTypeService {

    private final UserTypeRepository userTypeRepository;
    private final UserTypeMapper mapper;

    public void create(UserTypeDto dto) {

        UserType userType = mapper.dtoToModel(dto);
        userType.setCreatedAt(LocalDateTime.now());
        userType.setStatus(true);
        userTypeRepository.save(userType);
    }

    public List<UserTypeDto> getAll() {
        return userTypeRepository.findAllAndDeletedAtIsNull()
                .stream()
                .map(mapper::modelToDto)
                .collect(Collectors.toList());
    }

    public UserTypeDto getOne(Integer id) {
        return mapper.modelToDto(getEntity(id));
    }

    public void update(Integer id, UserTypeDto dto) {

        UserType userType = getEntity(id);
        UserType userType1 = mapper.dtoToModel(dto);
        userType1.setStatus(userType.getStatus());
        userType1.setCreatedAt(userType.getCreatedAt());
        userType1.setUpdatedAt(LocalDateTime.now());
        userTypeRepository.save(userType1);
    }

    public void delete(Integer id) {

        UserType userType = getEntity(id);
        userType.setDeletedAt(LocalDateTime.now());
        userTypeRepository.save(userType);
    }


    // |- SECONDARY FUNCTIONS -|

    public UserType getEntity(Integer id){
        return userTypeRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(()-> new ServerBadRequestException("User Type not found!"));
    }
}
