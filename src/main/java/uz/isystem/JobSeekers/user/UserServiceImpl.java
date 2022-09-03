package uz.isystem.JobSeekers.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.isystem.JobSeekers.exception.ServerBadRequestException;
import uz.isystem.JobSeekers.user.role.Role;
import uz.isystem.JobSeekers.user.role.RoleRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

//    Get one user
    @Override
    public UserDto getUserById(Integer id) {
        return userMapper.modelToDto(getEntity(id));
    }

//    Create user
    @Override
    public void createUser(UserDto userDto) {
        User user = userMapper.dtoToModel(userDto);
        user.setStatus(true);
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
    }

//    Update user
    @Override
    public void update(Integer id, UserDto userDto) {
        User user = getEntity(id);

        User newUser = userMapper.dtoToModel(userDto);
        newUser.setId(id);
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setStatus(user.getStatus());
        newUser.setUpdatedAt(LocalDateTime.now());

        userRepository.save(newUser);
    }

//    Delete user
    @Override
    public void deleteUser(Integer id) {
        User user = getEntity(id);
        user.setDeletedAt(LocalDateTime.now());
        userRepository.save(user);
    }

//    Get all users
    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAllByDeletedAtIsNull();
        if (userList.isEmpty()) throw new ServerBadRequestException("User not found !");

        return userList.stream().map(user -> userMapper.modelToDto(user)).collect(Collectors.toList());
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleRepository.findByName(roleName);
    }

    public User getEntity(Integer id) {
        return userRepository.findByIdAndDeletedAtIsNull(id).orElseThrow(() -> new ServerBadRequestException("User not found !"));
    }

    public User getUserByUsername(String username){
        User user = userRepository.findByUsername(username);
        if(user == null)
            throw new ServerBadRequestException("User not found !");
        return user;
    }

    @Override
    public void saveRole(Role role) {
        log.info("Saving new role {} to database", role.getName());
        roleRepository.save(role);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            log.error("User not found in the database !!");
            throw new UsernameNotFoundException("User not found !", new Throwable("hello"));
        } else {
            log.info("User found in the database: {}", username);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails
                .User(user.getUsername(), user.getPassword(), user.getStatus(), true, true, true, authorities);
    }
}
