package com.example.fastcargo.controller;

import com.example.fastcargo.dto.CourierDto;
import com.example.fastcargo.dto.CourierRequest;
import com.example.fastcargo.dto.UserDto;
import com.example.fastcargo.dto.UserRequest;
import com.example.fastcargo.service.CourierService;
import com.example.fastcargo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class ClientController {

    private final UserService userService;
    private final CourierService courierService;

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @PostMapping("/createAdmin")
    public ResponseEntity<UserDto> createAdmin(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.createApplicationAdmin(userRequest));
    }

    @PostMapping("createCourier")
    public ResponseEntity<CourierDto> createCourier(@RequestBody CourierRequest courierRequest) {
        return ResponseEntity.ok(courierService.createCourier(courierRequest));
    }
}
