package it.corrado.controller.impl;

import it.corrado.controller.UsersController;
import it.corrado.dto.UserDto;
import it.corrado.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UsersControllerImpl implements UsersController {
    @Autowired
    private final UserService userService;
    @Override
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
}
