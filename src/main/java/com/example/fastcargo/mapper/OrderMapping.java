package com.example.fastcargo.mapper;

import com.example.fastcargo.dto.OrderCourierDto;
import com.example.fastcargo.dto.OrderRequest;
import com.example.fastcargo.dto.SetOrderToCourierRequest;
import com.example.fastcargo.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
                                   unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface OrderMapping {

    List<OrderRequest> convertToDto(List<Order> orders);

    List<OrderCourierDto>convertToDtoEmail(List<Order> courierEmail);

    OrderRequest convertToDto(Order order);

    OrderCourierDto convertToOrderCourierDto(Order order);





}
