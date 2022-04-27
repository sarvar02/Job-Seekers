package uz.isystem.JobSeekers.userType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserTypeService {

    private final UserTypeRepository userTypeRepository;
}
