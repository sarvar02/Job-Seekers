package uz.isystem.JobSeekers.subject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody SubjectDto subjectDto){
        subjectService.create(subjectDto);
        return new ResponseEntity<>("Ok, Subject Created!", HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(subjectService.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") Long id){
        return ResponseEntity.ok(subjectService.getOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id,
                                    @RequestBody SubjectDto subjectDto){
        subjectService.update(id, subjectDto);
        return new ResponseEntity<>("Ok, Subject updated!", HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        subjectService.delete(id);
        return ResponseEntity.ok("Ok, deleted!");
    }
}
