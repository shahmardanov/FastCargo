package com.example.fastcargo.mapper;

import com.example.fastcargo.dto.CourierDto;
import com.example.fastcargo.model.Courier;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
                                   unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CourierMapping {

    Courier convertToDto (CourierDto courierDto);

    CourierDto convertToEntity(Courier courier);
}
