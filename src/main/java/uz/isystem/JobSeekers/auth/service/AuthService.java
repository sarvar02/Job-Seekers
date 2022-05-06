package uz.isystem.JobSeekers.auth.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.isystem.JobSeekers.auth.dto.RegistrationDto;
import uz.isystem.JobSeekers.exception.ServerBadRequestException;
import uz.isystem.JobSeekers.security.filter.CustomAuthenticationFilter;
import uz.isystem.JobSeekers.user.User;
import uz.isystem.JobSeekers.user.UserRepository;
import uz.isystem.JobSeekers.user.UserService;
import uz.isystem.JobSeekers.user.role.Role;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private CustomAuthenticationFilter filter;
    private final AuthenticationManager authenticationManager;
    private final MailSenderService mailSenderService;

    @Value("${mailSendAddress}")
    private String address;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       UserService userService,
                       AuthenticationManager authenticationManager,
                       MailSenderService mailSenderService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.filter = new CustomAuthenticationFilter(authenticationManager);
        this.mailSenderService = mailSenderService;
    }

    public void register(RegistrationDto dto){
        if(!dto.getPassword().equals(dto.getCheckPassword()))
            throw new ServerBadRequestException("invalid password !");

        User optional = userRepository.findByUsername(dto.getUsername());
        if(optional != null)
            throw new ServerBadRequestException("User already exist !");

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setEmail(dto.getEmail());
        Role role = userService.getRoleByName("ROLE_USER");
        user.getRoles().add(role);
        userRepository.save(user);

        String link = address + filter.generateToken(user);
        String content = String.format("Please verify your data, click to link %s", link);

//        Todo Send Mail
        mailSenderService.sendMail(content, dto.getEmail());
    }

    public User verification(String token) {
        User user = userRepository.findByUsername(filter.getUsername(token));
        if (user == null) {
            throw new ServerBadRequestException("Verification failed");
        }
        user.setStatus(true);
        userRepository.save(user);
        return user;
    }
}
