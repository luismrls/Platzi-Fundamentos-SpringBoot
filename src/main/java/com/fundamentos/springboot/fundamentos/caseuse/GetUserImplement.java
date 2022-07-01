package com.fundamentos.springboot.fundamentos.caseuse;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GetUserImplement implements GetUser{

    @Autowired
    private UserService userService;

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
