package com.springbootMock.service.impl;

import com.springbootMock.doMain.User;
import com.springbootMock.mapper.UserMapper;
import com.springbootMock.service.IUserServeice;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements IUserServeice {

    @Autowired
    private IUserServeice iUserServeice;

    @Override
    public List<User> getUserList() {
        return iUserServeice.getUserList();
    }
}
