package com.jsp.ebanking.service;


import java.security.SecureRandom;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.ebanking.dto.ResponseDto;
import com.jsp.ebanking.dto.UserDto;
import com.jsp.ebanking.exception.DataExistsException;

import com.jsp.ebanking.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	
	private final RedisService redisService;
	private final UserRepository userRepository;

	@Override
	public ResponseEntity<ResponseDto> register(UserDto dto) {
		if (redisService.fetchUserDto(dto.getEmail()) == null) {
			if (!userRepository.existsByEmailOrMobile(dto.getEmail(), dto.getMobile())) {
				int otp = new SecureRandom().nextInt(1000, 10000);
				redisService.saveUserDto(dto);
				redisService.saveUserOtp(dto.getEmail(), otp);
				return ResponseEntity.status(201).body(new ResponseDto("Otp Sent Verify", dto));
			} else {
				throw new DataExistsException(
						"Account Already Exists with " + dto.getEmail() + " or " + dto.getMobile());
			}
		} else {
			throw new DataExistsException(dto.getEmail() + " is Already being Verified if fails try after 15 mins");
		}
	}
		public String check(String email) {
			int a = redisService.fetchOtp(email);
			UserDto b = redisService.fetchUserDto(email);
			return "" + a + " ------ " + b;
		}

}