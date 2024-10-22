package com.example.fastcargo.mapper;

import com.example.fastcargo.dto.UserDto;
import com.example.fastcargo.dto.UserRequest;
import com.example.fastcargo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
                                   unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapping {

    UserDto convertToDto(User user);
    User convertToEntity(UserDto userDto);
}
