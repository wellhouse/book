package com.recipebook.user.service;

import com.recipebook.user.dto.UserDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface UserService {

    public Slice<UserDto> getUsers(Pageable page);

}
