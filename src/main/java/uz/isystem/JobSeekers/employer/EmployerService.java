package uz.isystem.JobSeekers.employer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.isystem.JobSeekers.country.CountryService;
import uz.isystem.JobSeekers.exception.ServerBadRequestException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EmployerService {

    private final EmployerRepository employerRepository;
    private final EmployerMapper employerMapper;
    private final CountryService countryService;

//    Get One Employer By Id

    public EmployerDto  getEmployerById(Integer id){
        EmployerDto employerDto = employerMapper.modelToDto(getEntity(id));
        employerDto.setCountryDto(countryService.getOne(id));
        return employerDto;
    }

//    Create Employer

    public void createEmployer(EmployerDto employerDto){
        Employer employer = employerMapper.dtoToModel(employerDto);
        employer.setCreatedAt(LocalDateTime.now());
        employer.setStatus(true);
        employerRepository.save(employer);
    }

//    Update Employer

    public void updateEmployer(Integer id, EmployerDto employerDto){

        Employer employer = getEntity(id);

        Employer newEmployer = employerMapper.dtoToModel(employerDto);
        newEmployer.setCreatedAt(employer.getCreatedAt());
        newEmployer.setUpdatedAt(LocalDateTime.now());
        newEmployer.setStatus(employer.getStatus());
        newEmployer.setId(id);
        employerRepository.save(newEmployer);
    }

//    Delete Employer

    public void deleteEmployer(Integer id){
        Employer employer = getEntity(id);
        employer.setDeletedAt(LocalDateTime.now());
        employerRepository.save(employer);
    }


//    Get All Employers

    public List<EmployerDto> getAllEmployers(){
        List<Employer> employerList = employerRepository.findAllByDeletedAtIsNull();
        if(employerList.isEmpty())
            throw new ServerBadRequestException("Employer not found !");

        return employerList.stream()
                .map(employer -> {
                    EmployerDto employerDto = employerMapper.modelToDto(employer);
                    employerDto.setCountryDto(countryService.getOne(employerDto.getCountryId()));
                    return employerDto;
                })
                .collect(Collectors.toList());
    }

    public Employer getEntity(Integer id){
        return employerRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ServerBadRequestException("Employer Not Found !"));
    }

}
