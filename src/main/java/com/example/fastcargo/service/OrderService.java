package com.example.fastcargo.service;

import com.example.fastcargo.dto.*;
import com.example.fastcargo.mapper.OrderMapping;
import com.example.fastcargo.model.Order;
import com.example.fastcargo.repository.OrderRepository;
import com.example.fastcargo.status.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapping orderMapping;
    private final UserService userService;
    private final CourierService courierService;

    public OrderRequest creatOrder(CreateOrderDto orderRequest) {
        userService.checkUser(orderRequest.getUserMail());
        Order order = new Order(
                orderRequest.getOrderName(),
                orderRequest.getAddress(),
                Status.COMPLETED,
                orderRequest.getUserMail());
        return orderMapping.convertToDto(orderRepository.save(order));
    }

    public List<OrderRequest> getAllOrdersByUserEmail(String userEmail) {
        return orderMapping.convertToDto(orderRepository.findAllByUserEmail(userEmail));
    }

    public OrderRequest updateOrderStatus(Long id, UpdateOrderDestination updateOrderDestination) {
        Order order = findOrderById(id);
        order.setDestination(updateOrderDestination.getAddress());
        orderRepository.save(order);
        return orderMapping.convertToDto(order);
    }

    public Order findOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found with ID: " + orderId));
    }

    public void deleteOrderById(Long orderId) {
        findOrderById(orderId);
        orderRepository.deleteById(orderId);
    }

    public OrderRequest getOrderById(Long id){
 return orderMapping.convertToDto(findOrderById(id));
    }

    public OrderCourierDto assignOrder(Long orderId, SetOrderToCourierRequest setOrderToCourierRequest) {
        Order order = findOrderById(orderId);
        courierService.changeCourierStatus(setOrderToCourierRequest.getCourierEmail());
        order.setCourierEmail(setOrderToCourierRequest.getCourierEmail());
        order.setStatus(Status.IN_THE_COURIER);
        return orderMapping.convertToOrderCourierDto(orderRepository.save(order));
    }

    public List<OrderCourierDto> getAllOrdersByCourierEmail(String courierEmail) {
        courierService.findCourierByEmail(courierEmail);
        return orderMapping.convertToDtoEmail(orderRepository.findAllByCourierEmail(courierEmail));
    }

    public OrderCourierDto changeOrderStatus(Long orderId, UpdateOrderStatus orderStatus) {
        Order order = findOrderById(orderId);
        order.setStatus(Status.valueOf(orderStatus.getStatus()));
        return orderMapping.convertToOrderCourierDto(order);
    }

}
