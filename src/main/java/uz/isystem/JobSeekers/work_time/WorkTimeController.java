package uz.isystem.JobSeekers.work_time;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/work-time")
public class WorkTimeController {

    private final WorkTimeService workTimeService;

}
