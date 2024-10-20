package com.example.fastcargo.service;

import com.example.fastcargo.dto.CourierDto;
import com.example.fastcargo.dto.CourierRequest;
import com.example.fastcargo.mapper.CourierMapping;
import com.example.fastcargo.mapper.UserMapping;
import com.example.fastcargo.model.Courier;
import com.example.fastcargo.repository.CourierRepository;
import com.example.fastcargo.role.Role;
import com.example.fastcargo.status.CourierStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourierService {

    private final CourierRepository courierRepository;
    private final CourierMapping courierMapping;

    public CourierDto createCourier(CourierRequest courierRequest) {
        Courier courier = new Courier(
                courierRequest.getCourierName(),
                courierRequest.getCourierSurname(),
                courierRequest.getMail(),
                Role.COURIER,
                courierRequest.getCourierStatus(),
                courierRequest.getPassword());
        return courierMapping.convertToDto(courierRepository.save(courier));
    }

    public void changeCourierStatus(String courierEmail) {
        Courier courier = findCourierByEmail(courierEmail);
        courier.setCourierStatus(CourierStatus.AVAILABLE);
        courierMapping.convertToDto(courier);
    }

    public Courier findCourierByEmail(String courierEmail) {
        return courierRepository.findByMail(courierEmail).orElseThrow(() ->
                new IllegalStateException("Bu emailde kuryer tapilmadi!" + courierEmail));
    }

    public List<CourierDto> getAllCouriers() {
        return courierMapping.convertToDtoAll(courierRepository.findAll());
    }
}
