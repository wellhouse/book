package com.recipebook.recipe.dto.user.service;

import com.recipebook.model.Users;
import com.recipebook.recipe.dto.user.dto.UserDto;
import com.recipebook.recipe.dto.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Slice<UserDto> getUsers(Pageable page) {

        Slice<Users> userSlice = userRepository.findAll(page);

        Slice<UserDto> dtoSlice = userSlice.map(entity -> {
            UserDto userDto = modelMapper.map(entity, UserDto.class);
            return userDto;
        });
        return dtoSlice;
    }
}
