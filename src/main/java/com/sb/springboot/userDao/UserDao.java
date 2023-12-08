package com.sb.springboot.userDao;


import com.sb.springboot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    User getOne(Long id);

    void createUser(User user);

    void deleteUser(long id);

    public void update(User updatedUser, Long id);
}
