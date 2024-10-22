package com.example.fastcargo.controller;

import com.example.fastcargo.dto.CreateOrderDto;
import com.example.fastcargo.dto.OrderRequest;
import com.example.fastcargo.dto.UpdateOrderDestination;
import com.example.fastcargo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/orders")
@RequiredArgsConstructor
public class UserController {

    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<OrderRequest> createOrder(@RequestBody CreateOrderDto orderDto) {
        return ResponseEntity.ok(orderService.creatOrder(orderDto));
    }

    @PutMapping("/updateorder/{addressId}")
    public ResponseEntity<OrderRequest> updateOrderByAddress(@PathVariable(name = "addressId") Long id, @RequestBody UpdateOrderDestination updateOrderDestination) {
        return ResponseEntity.ok(orderService.updateOrderStatus(id, updateOrderDestination));
    }

    @GetMapping("/{email}")
    public ResponseEntity<List<OrderRequest>> getAllOrdersByEmail(@PathVariable String email) {
        return ResponseEntity.ok(orderService.getAllOrdersByUserEmail(email));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<OrderRequest> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteOrderById(@PathVariable Long id) {
        orderService.deleteOrderById(id);
    }
}
