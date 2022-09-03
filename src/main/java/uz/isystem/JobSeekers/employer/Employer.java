package uz.isystem.JobSeekers.employer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.isystem.JobSeekers.country.Country;
import uz.isystem.JobSeekers.work_time.WorkTime;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = ("employers"))
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = ("name"))
    private String name;

    @Column(name = ("phone"))
    private String phone;

    @Column(name = ("salary"))
    private String salary;

    @Column(name = ("work_time_id"))
    private Integer workTimeId;

    @ManyToOne
    @JoinColumn(name = ("work_time_id"), insertable = false, updatable = false)
    private WorkTime workTime;

    @Column(name = ("country_id"), insertable = false, updatable = false)
    private Integer countryId;

    @ManyToOne
    @JoinColumn(name = ("country_id"), insertable = false, updatable = false)
    private Country country;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
