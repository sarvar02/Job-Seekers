package uz.isystem.JobSeekers.userType;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = ("user_types"))
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = ("name"))
    private String name;

    @Column(name = ("status"))
    private Boolean status;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;


    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;


    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
