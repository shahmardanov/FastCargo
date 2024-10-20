package com.example.fastcargo.service;

import com.example.fastcargo.dto.UserDto;
import com.example.fastcargo.dto.UserRequest;
import com.example.fastcargo.mapper.UserMapping;
import com.example.fastcargo.model.User;
import com.example.fastcargo.repository.UserRepository;
import com.example.fastcargo.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapping userMapping;


    public UserDto createUser(UserRequest userRequest) {
        User user = new User(
                userRequest.getUserName(),
                userRequest.getUserSurname(),
                userRequest.getUserEmail(),
                Role.USER,
                userRequest.getPassword());
        return userMapping.convertToDto(userRepository.save(user));
    }

    public UserDto createApplicationAdmin(UserRequest userRequest) {
        User admin = new User(
                userRequest.getUserName(),
                userRequest.getUserSurname(),
                userRequest.getUserEmail(),
                Role.ADMIN,
                userRequest.getPassword());
        return userMapping.convertToDto(userRepository.save(admin));
    }

    public void checkUser(String userMail) {
        userRepository.findByUserEmail(userMail).orElseThrow(() -> new IllegalStateException("Bele bir istiface movcud deyil!" + userMail));
    }

}
