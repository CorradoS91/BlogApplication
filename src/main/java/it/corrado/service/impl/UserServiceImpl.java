package it.corrado.service.impl;

import it.corrado.dto.UserDto;
import it.corrado.exception.NotFoundException;
import it.corrado.mapper.UserMapper;
import it.corrado.model.User;
import it.corrado.repository.UserRepository;
import it.corrado.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<User> userOpt = userRepository.getUserByEmail(user.getEmail());
        if(userOpt.isPresent()){
            throw new NotFoundException(null,null,user.getEmail(),"This email already exists: "+user.getEmail());
        }else{
            userRepository.save(user);
            return userMapper.userToUserDto(user);
        }
    }
    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->buildNotFoundException(id,null,null));
        UserDto userDto = userMapper.userToUserDto(user);
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
        User oldUser = userRepository.findById(id).orElseThrow(()->buildNotFoundException(id,null,null));
        userMapper.updateUser(userDto,oldUser);
        userRepository.save(oldUser);
        return userMapper.userToUserDto(oldUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> usersList = userRepository.findAll();
        return userMapper.listUserDtoToList(usersList);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(()->buildNotFoundException(id,null,null));
        userRepository.deleteById(id);
    }
    @Override
    public UserDto getUserByEmail(String email){
        User user  = userRepository.getUserByEmail(email).orElseThrow(()->buildNotFoundException(null,email,null));
        return userMapper.userToUserDto(user);
    }
    @Override
    public UserDto getUserByNickname(String nickName){
        User user = userRepository.getUserByNickname(nickName).orElseThrow(()->buildNotFoundException(null,null,nickName));
        return userMapper.userToUserDto(user);
    }
    private RuntimeException buildNotFoundException(Long id,String email,String nickName) {
        NotFoundException exception = new NotFoundException();
        exception.setIdNotFound(id);
        exception.setEmailNotFound(email);
        exception.setNicknameNotFound(nickName);
        if(id!=null){
            String ms ="The following Id was not found: %d";
            exception.setMessage(String.format(ms,id));
            return exception;
        }
        if(email!=null) {
            String ms ="The following Email was not found: %s";
            exception.setMessage(String.format(ms,email));
            return exception;
        }
        if(nickName!=null) {
            String ms ="The following Nickname was not found: %s";
            exception.setMessage(String.format(ms,nickName));
            return exception;
        }
        return null;
    }

}
