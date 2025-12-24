package com.jsp.ebanking.service;


import org.springframework.http.ResponseEntity;

import com.jsp.ebanking.dto.UserDto;
import com.jsp.ebanking.entity.TempUser;

public interface UserService {

	ResponseEntity<TempUser> register(UserDto dto);

	ResponseEntity<TempUser> fetch(String email);

}