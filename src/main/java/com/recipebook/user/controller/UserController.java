package com.recipebook.user.controller;

import com.recipebook.user.dto.UserDto;
import com.recipebook.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/all")
    public ResponseEntity<Slice<UserDto>> getAllEmployees(@PageableDefault(sort = "name",  direction = Sort.Direction.ASC,  page = 0, size = 10) Pageable page){
        Slice<UserDto> users = userService.getUsers(page);
        return ResponseEntity.ok().body(users);
    }
}
