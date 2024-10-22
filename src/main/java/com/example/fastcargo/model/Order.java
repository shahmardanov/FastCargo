package com.example.fastcargo.model;

import com.example.fastcargo.status.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderName;
    private String destination;
    private Status status;
    private String courierEmail;
    private String userEmail;

    public Order(String orderName, String courierName, String destination, String userEmail, Status status) {
        this.orderName = orderName;
        this.courierEmail = courierName;
        this.destination = destination;
        this.userEmail = userEmail;
        this.status = status;
    }

    public Order(String orderName, String courierName, String destination, Status status, String userEmail) {
        this(orderName, courierName, destination, userEmail, status);
        this.status = status;
    }

    public Order(String orderName, String destination, Status status, String userEmail) {
        this(orderName, null, destination, userEmail, status);
        this.status = status;
    }
}
