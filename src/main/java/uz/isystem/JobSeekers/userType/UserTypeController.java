package uz.isystem.JobSeekers.userType;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user-type")
public class UserTypeController {

    private final UserTypeService userTypeService;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody UserTypeDto dto){
        userTypeService.create(dto);
        return new ResponseEntity<>("Ok, User Type created!", HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(userTypeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") Integer id){
        return ResponseEntity.ok(userTypeService.getOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,
            @RequestBody UserTypeDto dto){
        userTypeService.update(id, dto);
        return ResponseEntity.ok("Ok, User Type is updated!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        userTypeService.delete(id);
        return ResponseEntity.ok("Ok, User Type deleted!");
    }
}
