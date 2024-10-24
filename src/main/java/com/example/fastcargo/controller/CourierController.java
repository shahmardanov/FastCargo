package com.example.fastcargo.controller;

import com.example.fastcargo.dto.OrderCourierDto;
import com.example.fastcargo.dto.UpdateOrderStatus;
import com.example.fastcargo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courier")
public class CourierController {

    private final OrderService orderService;

    @GetMapping("/getAllAssignedOrders/{email}")
    public ResponseEntity<List<OrderCourierDto>> getAllAssignedOrders(@PathVariable String email) {
        return ResponseEntity.ok(orderService.getAllOrdersByCourierEmail(email));
    }

    @PutMapping("/changeOrderStatus/{orderId}")
    public ResponseEntity<OrderCourierDto> changeOrderStatus(@PathVariable(name = "orderId") Long orderId, @RequestBody UpdateOrderStatus orderStatus) {
        return ResponseEntity.ok(orderService.changeOrderStatus(orderId, orderStatus));
    }
}
