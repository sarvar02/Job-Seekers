package uz.isystem.JobSeekers.auth.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationDto {
    @NotBlank(message = "enter username")
    private String username;
    @NotBlank(message = "enter password")
    private String password;
    @NotBlank(message = "enter password")
    private String checkPassword;
    @NotBlank(message = "enter email")
    private String email;
}
