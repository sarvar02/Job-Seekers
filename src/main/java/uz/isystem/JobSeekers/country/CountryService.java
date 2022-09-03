package uz.isystem.JobSeekers.country;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.isystem.JobSeekers.exception.ServerBadRequestException;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper mapper;


    public void create(CountryDto countryDto) {

        Country country = mapper.dtoToModel(countryDto);
        country.setCreatedAt(LocalDateTime.now());
        country.setStatus(true);
        countryRepository.save(country);
    }

    public List<CountryDto> getAll() {

        return countryRepository.findAllAndDeletedAtIsNull()
                .stream()
                .map(mapper::modelToDto)
                .collect(Collectors.toList());
    }

    public CountryDto getOne(Integer id) {
        return mapper.modelToDto(getEntity(id));
    }

    public void update(Integer id, CountryDto countryDto) {

        Country country = getEntity(id);
        Country country1 = mapper.dtoToModel(countryDto);
        country1.setCreatedAt(country.getCreatedAt());
        country1.setUpdatedAt(LocalDateTime.now());
        country1.setStatus(country.getStatus());
        countryRepository.save(country1);
    }

    public void delete(Integer id) {

        Country country = getEntity(id);
        country.setDeletedAt(LocalDateTime.now());
        countryRepository.save(country);
    }

    // |- SECONDARY FUNCTIONS -|

    public Country getEntity(Integer id) {
        return countryRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ServerBadRequestException("Country not found!"));
    }
}
