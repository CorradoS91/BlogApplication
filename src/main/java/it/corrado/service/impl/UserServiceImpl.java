package it.corrado.service.impl;

import it.corrado.dto.UserDto;
import it.corrado.mapper.UserMapper;
import it.corrado.model.User;
import it.corrado.repository.UserRepository;
import it.corrado.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserMapper userMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        userRepository.save(user);
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
        User oldUser = userRepository.findById(id).orElseThrow();
        userMapper.updateUser(userDto,oldUser);
        userRepository.save(oldUser);
        return userMapper.userToUserDto(oldUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow();
        userRepository.deleteById(id);
    }
}
