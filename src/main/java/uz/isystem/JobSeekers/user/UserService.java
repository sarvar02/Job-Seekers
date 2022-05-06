package uz.isystem.JobSeekers.user;

import uz.isystem.JobSeekers.user.role.Role;

import java.util.List;

public interface UserService {
    UserDto getUserById(Integer id);
    void createUser(UserDto userDto);
    void update(Integer id, UserDto userDto);
    void deleteUser(Integer id);
    List<UserDto> getAllUsers();
    Role getRoleByName(String roleName);
    User getUserByUsername(String username);
    void saveRole(Role role);
}
