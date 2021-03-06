package uz.isystem.JobSeekers.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.isystem.JobSeekers.country.Country;
import uz.isystem.JobSeekers.subject.Subject;
import uz.isystem.JobSeekers.user.role.Role;
import uz.isystem.JobSeekers.userType.UserType;
import uz.isystem.JobSeekers.work_time.WorkTime;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = ("users"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = ("name"))
    private String name;

    @Column(name = ("email"))
    private String email;

    @Column(name = ("phone"))
    private String phone;

    @Column(name = ("github_link"))
    private String githubLink;

    @Column(name = ("linkedin_link"))
    private String linkedInLink;

    @Column(name = ("username"))
    private String username;

    @Column(name = ("password"))
    private String password;

    @Column(name = ("number_of_responses"))
    private Integer numberOfResponses;

    @Column(name = ("user_type_id"))
    private Integer userTypeId;

    @ManyToOne
    @JoinColumn(name = "user_type_id", insertable = false, updatable = false)
    private UserType userType;

    @Column(name = ("address"))
    private String address;

    @Column(name = ("info"))
    private String info;

    @Column(name = ("work_time_id"))
    private Integer workTimeId;

    @ManyToOne
    @JoinColumn(name = ("work_time_id"), insertable = false, updatable = false)
    private WorkTime workTime;

    @Column(name = ("subject_id"))
    private Integer subjectId;

    @ManyToMany
    @JoinTable(
            name = "user_subjects",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> subjects;

    @Column(name = ("country_id"))
    private Integer countryId;

    @ManyToOne
    @JoinColumn(name = "country_id", insertable = false, updatable = false)
    private Country country;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    @Column(name = "status")
    private Boolean status = false;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
