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

    public User(String firstName, String lastName, String mail, Role role, String password) {
        this.userName = firstName;
        this.userSurname = lastName;
        this.userEmail = mail;
        this.role = role;
        this.password = password;
    }
    public User(String firstName, String lastName, String mail, String password) {
        this.userName = firstName;
        this.userSurname = lastName;
        this.userEmail = mail;
        this.password = password;
    }

}
