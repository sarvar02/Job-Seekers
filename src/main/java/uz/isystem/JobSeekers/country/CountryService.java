package uz.isystem.JobSeekers.country;

import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.List;

@Data
@Service
public class CountryService {

    private final CountryRepository countryRepository;


    public void create(CountryDto countryDto) {


    }

    public List<CountryDto> getAll() {
        return null;
    }

    public CountryDto getOne(Integer id) {
        return null;
    }

    public void update(Integer id, CountryDto countryDto) {
    }

    public void delete(Integer id) {
    }
}
