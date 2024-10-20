package com.example.fastcargo.repository;

import com.example.fastcargo.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourierRepository extends JpaRepository<Courier,Long> {
Optional<Courier>findByMail(String email);
}
