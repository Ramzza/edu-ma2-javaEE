package edu.bbte.bibliospring.service;

import edu.bbte.bibliospring.model.entity.User;

public interface UserService {
    public User registerUser(User user);

    public User login(User user);
}
