package com.example.fastcargo.dto;

import com.example.fastcargo.status.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SetOrderToCourierRequest {

    private Long id;
    private String name;
    private String destination;
    private Status status;
    private String courierName;
    private String userName;
}
