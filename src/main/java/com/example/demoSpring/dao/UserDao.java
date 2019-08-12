package com.example.demoSpring.dao;

import com.example.demoSpring.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserDao extends CrudRepository<User,Long> {
    public List<User>findAll();
}
