package uz.isystem.JobSeekers.country;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.w3c.dom.CDATASection;

import java.util.List;

@Data
@Service
public class CountryService {

    private final CountryRepository countryRepository;


    public void create(CountryDto countryDto) {


    }

    public List<CountryDto> getAll() {
    }

    public CountryDto getOne(Integer id) {
    }

    public void update(Integer id, CountryDto countryDto) {
    }

    public void delete(Integer id) {
    }
}
