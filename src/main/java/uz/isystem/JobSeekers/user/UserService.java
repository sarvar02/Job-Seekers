package uz.isystem.JobSeekers.user;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.isystem.JobSeekers.exception.ServerBadRequestException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

//    Get one user

    public UserDto getUserById(Integer id){
        return userMapper.modelToDto(getEntity(id));
    }

//    Create user

    public void createUser(UserDto userDto){
        User user = userMapper.dtoToModel(userDto);
        user.setStatus(true);
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
    }

//    Update user

    public void update(Integer id, UserDto userDto){
        User user = getEntity(id);

        User newUser = userMapper.dtoToModel(userDto);
        newUser.setId(id);
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setStatus(user.getStatus());
        newUser.setUpdatedAt(LocalDateTime.now());

        userRepository.save(newUser);
    }

//    Delete user

    public void deleteUser(Integer id){
        User user = getEntity(id);
        user.setDeletedAt(LocalDateTime.now());
        userRepository.save(user);
    }

//    Get all users

    public List<UserDto> getAllUsers(){
        List<User> userList = userRepository.findAllByDeletedAtIsNull();
        if(userList.isEmpty())
            throw new ServerBadRequestException("User not found !");

        return userList.stream()
                .map(user -> userMapper.modelToDto(user))
                .collect(Collectors.toList());
    }


    public User getEntity(Integer id){
        return userRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ServerBadRequestException("User not found !"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
