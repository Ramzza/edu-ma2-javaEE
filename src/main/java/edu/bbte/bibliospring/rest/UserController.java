package edu.bbte.bibliospring.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import edu.bbte.bibliospring.model.dto.UserDTO;
import edu.bbte.bibliospring.model.dto.UserEditableDTO;
import edu.bbte.bibliospring.model.entity.User;
import edu.bbte.bibliospring.repository.UserRepository;
import edu.bbte.bibliospring.model.mapper.UserDTOMapper;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDTOMapper userDTOMapper;

    @Autowired
    private UserRepository repository;

    UserController() {
    }

    @GetMapping
    List<UserDTO> all() {
        List<UserDTO> users = new ArrayList<>();
        repository.findAll().stream().forEach((User user) -> users.add(userDTOMapper.modelToDto(user)));
        return users;
    }

    @GetMapping("/{id}")
    UserDTO one(@PathVariable Long id) {
        return userDTOMapper.modelToDto(repository.findById(id).orElse(null));
    }

    @PutMapping("/{id}")
    UserDTO updateUser(@RequestBody UserEditableDTO modifiedUser, @PathVariable Long id) {

        return repository.findById(id)
                .map(user -> {
                    user.setFirstName(modifiedUser.getFirstName());
                    user.setLastName(modifiedUser.getLastName());
                    user.setEmail(modifiedUser.getEmail());
                    user.setAddress(modifiedUser.getAddress());
                    user.setPhoneNumber(modifiedUser.getPhoneNumber());
                    return userDTOMapper.modelToDto(repository.save(user));
                })
                .orElseGet(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exist");
                });
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}