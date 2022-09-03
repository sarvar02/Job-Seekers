package uz.isystem.JobSeekers.work_time;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/work-time")
public class WorkTimeController {

    private final WorkTimeService workTimeService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        return ResponseEntity.ok(workTimeService.getWorkTimeById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody WorkTimeDto workTimeDto){
        workTimeService.createWorkTime(workTimeDto);
        return new ResponseEntity<>("New Work Time Create !", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,
                                    @RequestBody WorkTimeDto workTimeDto){
        workTimeService.updateWorkTime(id, workTimeDto);
        return new ResponseEntity<>("Work time successfully updated !", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        workTimeService.deleteWorkTime(id);
        return new ResponseEntity<>("Work time successfully deleted !", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(workTimeService.getAllWorkTimes());
    }

}
