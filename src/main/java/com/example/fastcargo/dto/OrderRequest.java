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
public class OrderRequest {
    private Long id;
    private String orderName;
    private String destination;
    private String userEmail;
    private Status status;
}
