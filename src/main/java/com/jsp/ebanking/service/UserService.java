package com.jsp.ebanking.service;


import org.springframework.http.ResponseEntity;

import com.jsp.ebanking.dto.ResponseDto;
import com.jsp.ebanking.dto.UserDto;


public interface UserService {

	ResponseEntity<ResponseDto> register(UserDto dto);
	String check(String email);

}