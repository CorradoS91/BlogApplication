package it.corrado.controller;

import it.corrado.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RequestMapping("/users")
public interface UsersController {
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    List<UserDto> getAllUsers();
}
