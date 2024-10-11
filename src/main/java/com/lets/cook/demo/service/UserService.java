package com.lets.cook.demo.service;

import com.lets.cook.demo.entity.User;

import java.util.List;

public interface UserService {
    User create(User user);
    List<User> findUsers();
    String update(User user);
    String delete(Long id);
}
