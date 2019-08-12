package com.example.demoSpring.service;

import com.example.demoSpring.dao.UserDao;
import com.example.demoSpring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> findAll(){
        return userDao.findAll();
    }

    public boolean save(User user) {
        Optional<User> list = userDao.findById(user.getId());
        if (!list.isEmpty()){
            return false;
        }
        else {
            userDao.save(user);
            return true;
        }
    }

    public Optional<User> findById(Long id) {
        return userDao.findById(id);
    }
}
