package com.fundamentos.springboot.fundamentos.caseuse;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaginationUser {

    private UserService userService;

    public PaginationUser(UserService userService) {
        this.userService = userService;
    }

    public List<User> pagination(int page, int size) {
        return userService.pagination(page, size);
    }
}
