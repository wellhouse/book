package com.recipebook.user.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class UserDto {

    private UUID uuid;

    @NotNull(message = "name time cannot be null")
    @NotNull(message = "name cannot be null")
    @Size(min=5, max=50, message = "Name must must be between {min} and {max}")
    private String name;

    @NotNull(message = "surname time cannot be null")
    @NotNull(message = "surname cannot be null")
    @Size(min=5, max=50, message = "Name must must be between {min} and {max}")
    private String surname;

    @NotNull(message = "gender time cannot be null")
    @NotNull(message = "gender cannot be null")
    @Size(min=1, max=1, message = "Name must must be between {min} and {max}")
    private String gender;

    @NotNull(message = "email time cannot be null")
    @NotNull(message = "email cannot be null")
    @Size(min=10, max=50, message = "Name must must be between {min} and {max}")
    private String email;

}
