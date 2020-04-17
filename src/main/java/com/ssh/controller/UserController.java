package com.ssh.controller;

import com.ssh.dao.UserDao;
import com.ssh.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping("/getall")
    public List<User> get(){
        return userDao.getall();
    }
}
