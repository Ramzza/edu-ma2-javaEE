package edu.bbte.bibliospring.model.mapper;

import org.springframework.stereotype.Component;

import edu.bbte.bibliospring.model.dto.UserCompleteDTO;
import edu.bbte.bibliospring.model.dto.UserDTO;
import edu.bbte.bibliospring.model.dto.UserEditableDTO;
import edu.bbte.bibliospring.model.dto.UserMinimalDTO;
import edu.bbte.bibliospring.model.entity.User;

@Component
public class UserDTOMapper {

    public UserDTO modelToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setAddress(user.getAddress());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setType(user.getType());
        return userDTO;
    }

    public User dtoToModel(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setAddress(userDTO.getAddress());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setType(userDTO.getType());
        return user;
    }

    public User completeToModel(UserCompleteDTO userCompleteDTO) {
        User user = dtoToModel(userCompleteDTO);
        user.setPassword(userCompleteDTO.getPassword());
        return user;
    }

    public UserEditableDTO modelToEditable(User user) {
        UserEditableDTO userEditableDTO = new UserEditableDTO();
        userEditableDTO.setId(user.getId());
        userEditableDTO.setFirstName(user.getFirstName());
        userEditableDTO.setLastName(user.getLastName());
        userEditableDTO.setEmail(user.getEmail());
        userEditableDTO.setAddress(user.getAddress());
        userEditableDTO.setPhoneNumber(user.getPhoneNumber());
        return userEditableDTO;
    }

    public User editableToModel(UserEditableDTO userEditableDTO) {
        User user = new User();
        user.setId(userEditableDTO.getId());
        user.setFirstName(userEditableDTO.getFirstName());
        user.setLastName(userEditableDTO.getLastName());
        user.setEmail(userEditableDTO.getEmail());
        user.setAddress(userEditableDTO.getAddress());
        user.setPhoneNumber(userEditableDTO.getPhoneNumber());
        return user;
    }

    public UserMinimalDTO modelToMinimal(User user) {
        UserMinimalDTO userMinimalDTO = new UserMinimalDTO();
        userMinimalDTO.setId(user.getId());
        userMinimalDTO.setUsername(user.getUsername());
        userMinimalDTO.setFirstName(user.getFirstName());
        userMinimalDTO.setLastName(user.getLastName());
        return userMinimalDTO;
    }

    public User minimalToModel(UserMinimalDTO userMinimalDTO) {
        User user = new User();
        user.setId(userMinimalDTO.getId());
        user.setUsername(userMinimalDTO.getUsername());
        user.setFirstName(userMinimalDTO.getFirstName());
        user.setLastName(userMinimalDTO.getLastName());
        return user;
    }

}
