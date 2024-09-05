package it.corrado.service;


import it.corrado.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long id);
    UserDto getUserByEmail(String email);
    UserDto getUserByNickname(String nickName);
    UserDto updateUser(UserDto userDto, Long id);
    List<UserDto> getAllUsers();
    void deleteUser(Long id);

}
