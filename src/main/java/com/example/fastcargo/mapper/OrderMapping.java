package com.example.fastcargo.mapper;

import com.example.fastcargo.dto.OrderRequest;
import com.example.fastcargo.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
                                   unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface OrderMapping {

    Order convertToDto(OrderRequest orderRequest);

    OrderRequest convertToDto(Order order);
    Order convertToEntity(OrderRequest orderRequest);
}
