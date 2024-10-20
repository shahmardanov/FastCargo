package com.example.fastcargo.model;

import com.example.fastcargo.role.Role;
import com.example.fastcargo.status.CourierStatus;
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
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String mail;
    private String courierName;
    private String courierSurname;
    private String password;
    private Role role;
    private CourierStatus courierStatus;

}
