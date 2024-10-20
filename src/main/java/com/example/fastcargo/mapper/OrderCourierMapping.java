package com.example.fastcargo.mapper;

import com.example.fastcargo.dto.SetOrderToCourierRequest;
import com.example.fastcargo.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
                                   unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface OrderCourierMapping {

    SetOrderToCourierRequest convertToDto(Order order);
    Order convertToEntity(SetOrderToCourierRequest request);
}
