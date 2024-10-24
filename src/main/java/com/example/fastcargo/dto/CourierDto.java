package com.example.fastcargo.dto;

import com.example.fastcargo.role.Role;
import com.example.fastcargo.status.CourierStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourierDto {

    private String mail;
    private String courierName;
    private String courierSurname;
    private Role role;
    private CourierStatus courierStatus;
}
