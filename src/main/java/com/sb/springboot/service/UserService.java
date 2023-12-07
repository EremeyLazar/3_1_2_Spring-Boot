package com.sb.springboot.service;


import com.sb.springboot.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();

    public User getOne(Long id);

    public void createUser(User user);

    public void deleteUser(long id);

    public void update(User updatedUser, Long id);
}
