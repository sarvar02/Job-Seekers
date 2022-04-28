package uz.isystem.JobSeekers.subject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.isystem.JobSeekers.exception.ServerBadRequestException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectMapper mapper;
    private final SubjectRepository subjectRepository;

    public void create(SubjectDto subjectDto) {
        Subject subject = mapper.dtoToModel(subjectDto);
        subject.setStatus(true);
        subject.setCreatedAt(LocalDateTime.now());
        subjectRepository.save(subject);
    }


    public List<SubjectDto> getAll() {

        return subjectRepository.findAllByDeletedAtIsNull()
                .stream()
                .map(mapper::modelToDto)
                .collect(Collectors.toList());
    }

    public SubjectDto getOne(Long id) {
       return mapper.modelToDto(getEntity(id));
    }


    public void update(Long id, SubjectDto subjectDto) {
        getEntity(id);
        Subject subject = mapper.dtoToModel(subjectDto);
        subject.setId(id);
        subject.setUpdatedAt(LocalDateTime.now());
        subjectRepository.save(subject);
    }

    public void delete(Long id) {
        Subject subject = getEntity(id);
        subject.setDeletedAt(LocalDateTime.now());
        subjectRepository.save(subject);
    }


    // |- Secondary functions -|

    public Subject getEntity(Long id) {
        return subjectRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(()-> new ServerBadRequestException("Subject not found!"));
    }

}
