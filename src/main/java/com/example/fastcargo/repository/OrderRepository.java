package com.example.fastcargo.repository;

import com.example.fastcargo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByUserEmail(String userName);

    List<Order> findAllByCourierEmail(String courierName);

}
