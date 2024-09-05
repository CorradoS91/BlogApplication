package it.corrado.controller.impl;

import it.corrado.controller.UserController;
import it.corrado.dto.UserDto;
import it.corrado.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    @Autowired
    private final UserService userService;
    @Override
    public UserDto getUserById(Long id) {
        return userService.getUserById(id);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return userService.createUser(userDto);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        return userService.updateUser(userDto,id);
    }

    @Override
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }
}
