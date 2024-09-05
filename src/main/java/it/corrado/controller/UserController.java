package it.corrado.controller;

import it.corrado.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

    @RequestMapping("/user")
    public interface UserController {
        @GetMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        UserDto getUserById(@PathVariable(name="id")Long id);
        @GetMapping("/email/{email}")
        @ResponseStatus(HttpStatus.OK)
        UserDto getUserByEmail(@PathVariable(name="email")String email);
        @GetMapping("/nickname/{nickname}")
        @ResponseStatus(HttpStatus.OK)
        UserDto getUserByNickname(@PathVariable(name="nickname")String nickName);
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
