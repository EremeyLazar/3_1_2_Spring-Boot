package com.sb.springboot.service;

import com.sb.springboot.model.User;
import com.sb.springboot.userDao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAll() {
        List<User> resultList = userDao.getAll();
        return resultList;
    }

    public User getOne(Long id) {
        User user = userDao.getOne(id);
        return user;
    }

    @Transactional
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Transactional
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Transactional
    public void update(User updatedUser, Long id) {
        userDao.update(updatedUser, id);
    }
}
