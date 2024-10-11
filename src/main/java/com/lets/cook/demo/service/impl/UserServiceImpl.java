package com.lets.cook.demo.service.impl;

import com.lets.cook.demo.entity.User;
import com.lets.cook.demo.repository.UserRespository;
import com.lets.cook.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRespository userRespository;

    public UserServiceImpl(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    @Override
    public User create(User user) {
        userRespository.save(user);
        return user;
    }

    @Override
    public List<User> findUsers() {
        return userRespository.findAll();
    }

    @Override
    public String update(User user) {
        if (userRespository.existsById(user.getId())) {
            userRespository.save(user);
            return "success updated user id " + user.getId();
        } else {
            return "user with id " + user.getId() + " does not exist";
        }
    }

    @Override
    public String delete(Long id) {
        User deletedUser = userRespository.findById(id).orElse(null);
        if (deletedUser != null) {
            deletedUser.setIsActive(false);
            userRespository.save(deletedUser);
            return "deleted user id " + id;
        } else {
            return "user with id " + id + " does not exist";
        }
    }
}
