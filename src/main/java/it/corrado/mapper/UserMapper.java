package it.corrado.mapper;

import it.corrado.dto.UserDto;
import it.corrado.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
    List<UserDto> listUserDtoToList(List<User> userList);
    void updateUser(UserDto userDto, @MappingTarget User user);
}
