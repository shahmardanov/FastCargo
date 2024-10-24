package com.example.fastcargo.controller;

import com.example.fastcargo.dto.*;
import com.example.fastcargo.service.CourierService;
import com.example.fastcargo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/orders")
@RequiredArgsConstructor
public class AdminController {

    private final OrderService orderService;
    private final CourierService courierService;

    @PostMapping("/createCourier")
    public ResponseEntity<CourierDto> createCourier(@RequestBody CourierRequest courierRequest) {
        return ResponseEntity.ok(courierService.createCourier(courierRequest));
    }

    @GetMapping("/getAllCouriers")
    public ResponseEntity<List<CourierDto>> getAllCouriers() {
        return ResponseEntity.ok(courierService.getAllCouriers());
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderRequest>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @PutMapping("/setOrderToCourier/{orderId}")
    public ResponseEntity<OrderCourierDto> setOrderToCourier(@PathVariable(name = "orderId") Long id, @RequestBody SetOrderToCourierRequest setOrderToCourierRequest) {
        return ResponseEntity.ok(orderService.assignOrder(id, setOrderToCourierRequest));
    }

    @PutMapping("/changeOrderStatus/{orderId}")
    public ResponseEntity<OrderCourierDto> changeOrderStatus(@PathVariable(name = "orderId") Long id, @RequestBody UpdateOrderStatus updateOrderStatus) {
        return ResponseEntity.ok(orderService.changeOrderStatus(id, updateOrderStatus));
    }
}
