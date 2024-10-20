package com.example.fastcargo.dto;

import com.example.fastcargo.role.Role;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String userName;
    private String userSurname;
    private String userEmail;
    private Role role;
}
