package com.example.fastcargo.dto;

import com.example.fastcargo.status.CourierStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourierRequest {

    private String mail;
    private String courierName;
    private String courierSurname;
    private String password;
    private CourierStatus courierStatus;
}
