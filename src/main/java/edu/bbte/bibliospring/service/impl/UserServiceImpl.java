package edu.bbte.bibliospring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bbte.bibliospring.model.entity.User;
import edu.bbte.bibliospring.repository.UserRepository;
import edu.bbte.bibliospring.service.UserService;
import edu.bbte.bibliospring.util.PasswordEncrypter;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userDAO;

    @Override
    public User registerUser(User user) {
        user.setPassword(PasswordEncrypter.getHashFromPassword(user.getPassword()));
        return userDAO.save(user);
    }

    @Override
    public User login(User user) {
        try {
            User persistedUser = userDAO.findByUsername(user.getUsername());

            if (persistedUser == null) {
                return null;
            }

            user.setPassword(PasswordEncrypter.getHashFromPassword(user.getPassword()));

            if (persistedUser.getPassword().equals(user.getPassword())) {
                return persistedUser;
            }

        } catch (Exception e) {
            LOG.error(e.getMessage());
            return null;
        }
        return null;
    }
}
