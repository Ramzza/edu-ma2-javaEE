package edu.bbte.bibliospring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bbte.bibliospring.model.dto.UserCompleteDTO;
import edu.bbte.bibliospring.model.dto.UserDTO;
import edu.bbte.bibliospring.model.mapper.UserDTOMapper;
import edu.bbte.bibliospring.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDTOMapper userDTOMapper;

    @PostMapping("/register")
    UserDTO registerUser(@RequestBody UserCompleteDTO registerUser) {
        return userDTOMapper.modelToDto(userService.registerUser(userDTOMapper.completeToModel(registerUser)));
    }

    @PostMapping("/login")
    UserDTO loginUser(@RequestBody UserCompleteDTO loginUser) {
        return userDTOMapper.modelToDto(userService.login(userDTOMapper.completeToModel(loginUser)));
    }
}
