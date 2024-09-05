package it.corrado.controller;

import it.corrado.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

    @RequestMapping("/user")
    public interface UserController {
        @GetMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        UserDto getUserById(@PathVariable(name="id")Long id);
        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        UserDto createUser(@RequestBody UserDto userDto);
        @PutMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        UserDto updateUser(@PathVariable(name="id") Long id,@RequestBody UserDto userDto);
        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        void deleteUser(@PathVariable(name="id")Long id);
}
