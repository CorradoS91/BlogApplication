package it.corrado.service;


import it.corrado.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(long id);
    UserDto updateUser(UserDto userDto, long id);
    void deleteUser(long id);
}
