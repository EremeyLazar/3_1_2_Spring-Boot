package com.sb.springboot.service;


import com.sb.springboot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getOne(Long id);

    void createUser(User user);

    void deleteUser(long id);

    void update(User updatedUser, Long id);
}
