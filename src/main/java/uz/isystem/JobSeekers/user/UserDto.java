package uz.isystem.JobSeekers.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.isystem.JobSeekers.country.Country;
import uz.isystem.JobSeekers.subject.Subject;
import uz.isystem.JobSeekers.userType.UserType;
import uz.isystem.JobSeekers.work_time.WorkTime;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;
    @NotBlank(message = "Enter your name")
    private String name;
    @NotBlank(message = "Enter your email")
    private String email;
    @NotBlank(message = "Enter your phone")
    private String phone;
    private String githubLink;
    private String linkedInLink;
    @NotBlank(message = "Enter your username")
    private String username;
    @NotBlank(message = "Enter your password")
    private String password;
    private Integer numberOfResponses;
    private Integer userTypeId;
    private UserType userType;
    private String address;
    private String info;
    private Integer workTimeId;
    private WorkTime workTime;
    private Integer subjectId;
    private Set<Subject> subjects;
    private Integer countryId;
    private Country country;
}
