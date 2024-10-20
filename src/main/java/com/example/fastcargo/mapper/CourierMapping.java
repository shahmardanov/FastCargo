package com.example.fastcargo.mapper;

import com.example.fastcargo.dto.CourierDto;
import com.example.fastcargo.model.Courier;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
                                   unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CourierMapping {

    Courier convertToEntity (CourierDto courierDto);

    CourierDto convertToDto(Courier courier);
    List<CourierDto> convertToDtoAll(List<Courier> courier);

}
