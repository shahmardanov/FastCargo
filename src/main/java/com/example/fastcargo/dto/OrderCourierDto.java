package com.example.fastcargo.dto;

import com.example.fastcargo.role.Role;
import com.example.fastcargo.status.CourierStatus;
import com.example.fastcargo.status.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCourierDto {
    private Long id;
    private String name;
    private String userMail;
    private String courierName;
    private CourierStatus courierStatus;
    private Status status;
}
