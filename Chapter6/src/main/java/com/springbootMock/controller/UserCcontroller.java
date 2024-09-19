package com.springbootMock.controller;

import com.springbootMock.doMain.User;
import com.springbootMock.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserCcontroller {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/selectList")
    public List<User> getUserList() {

    }

}
