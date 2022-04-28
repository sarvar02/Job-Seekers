package uz.isystem.JobSeekers.employer;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.isystem.JobSeekers.country.Country;
import uz.isystem.JobSeekers.country.CountryDto;
import uz.isystem.JobSeekers.work_time.WorkTime;
import uz.isystem.JobSeekers.work_time.WorkTimeDto;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployerDto {
    private Integer id;
    private String name;
    private String phone;
    private String salary;
    private Integer workTimeId;
    private WorkTimeDto workTimeDto;
    private Integer countryId;
    private CountryDto countryDto;
    private Boolean status;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    private LocalDateTime updatedAt;
}
