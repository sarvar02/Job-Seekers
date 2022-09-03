package uz.isystem.JobSeekers.employer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/employer")
public class EmployerController {

    private final EmployerService employerService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployerById(@PathVariable Integer id){
        return ResponseEntity.ok(employerService.getEmployerById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody EmployerDto employerDto){
        employerService.createEmployer(employerDto);
        return new ResponseEntity<>("New Employer created !", HttpStatus.CREATED);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<?> updateEmployer(@PathVariable Integer id,
                                            @RequestBody EmployerDto employerDto){
        employerService.updateEmployer(id, employerDto);
        return new ResponseEntity<>("Employer successfully updated !", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployer(@PathVariable Integer id){
        employerService.deleteEmployer(id);
        return new ResponseEntity<>("Employer successfully deleted !", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployers(){
        return ResponseEntity.ok(employerService.getAllEmployers());
    }
}
