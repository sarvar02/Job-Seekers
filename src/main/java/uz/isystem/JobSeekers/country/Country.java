package uz.isystem.JobSeekers.country;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = ("countries"))
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = ("name"))
    private String name;

    @Column(name = ("city"))
    private String city;

    @Column(name = ("status"))
    private Boolean status;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;


    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;


    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}


