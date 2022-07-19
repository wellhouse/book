package com.recipebook.user.controller;

import com.recipebook.user.service.UserService;
import com.recipebook.user.dto.UserDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/book/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "Get all the user on the database with pagination. You have to use this api to create your user and be able to add recipes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - The users were not found")
    })
    @GetMapping(path = "/all")
    public ResponseEntity<Slice<UserDto>> getAllUsers(@PageableDefault(sort = "name",  direction = Sort.Direction.ASC,  page = 0, size = 10) Pageable page){
        Slice<UserDto> users = userService.getUsers(page);
        return ResponseEntity.ok().body(users);
    }

    @PostMapping
    @ApiOperation(value = "Add new user to the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 500, message = "Something went wrong during the requisition")
    })
    public ResponseEntity<UserDto> addNewUser(@Valid @RequestBody UserDto userDto) {
        UserDto users = userService.addUser(userDto);
        return ResponseEntity.ok().body(users);
    }
}
