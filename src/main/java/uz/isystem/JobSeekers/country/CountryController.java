package uz.isystem.JobSeekers.country;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/country")
public class CountryController {

    private final CountryService countryService;

// |- TODO: create function -|
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody CountryDto countryDto){
        countryService.create(countryDto);
        return new ResponseEntity<>("Ok created!", HttpStatus.CREATED);
    }

// |- TODO: getAll function -|
    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(countryService.getAll());
    }

// |- TODO: getOne function -|
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") Integer id){
        return ResponseEntity.ok(countryService.getOne(id));
    }

// |- TODO: update function -|
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,
                                    @RequestBody CountryDto countryDto){
        countryService.update(id, countryDto);
        return ResponseEntity.ok("Ok, Updated!");
    }

// |- TODO: delete function -|
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        countryService.delete(id);
        return ResponseEntity.ok("Ok, Deleted!");
    }
}
