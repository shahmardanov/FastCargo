package com.example.fastcargo.model;

import com.example.fastcargo.role.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String userSurname;

    @Column(unique = true)
    private String userEmail;
    private Role role;
    private String password;

    public User(String userName, String userSurname, String userEmail, Role role, String password) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userEmail = userEmail;
        this.role = role;
        this.password = password;
    }
}
