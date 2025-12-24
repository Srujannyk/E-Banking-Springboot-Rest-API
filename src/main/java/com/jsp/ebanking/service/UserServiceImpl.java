package com.jsp.ebanking.service;


import java.security.SecureRandom;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.ebanking.dto.UserDto;
import com.jsp.ebanking.entity.TempUser;
import com.jsp.ebanking.repository.TempUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	final TempUserRepository tempUserRepository;

	@Override
	public ResponseEntity<TempUser> register(UserDto dto) {
		TempUser tempUser = new TempUser(dto.getName(), dto.getEmail(), dto.getMobile(), dto.getDob(),
				dto.getPassword(), dto.getRole(), new SecureRandom().nextInt(1000, 10000));
		tempUserRepository.save(tempUser);
		return ResponseEntity.status(201).body(tempUser);
	}

	@Override
	public ResponseEntity<TempUser> fetch(String email) {
		return ResponseEntity.status(200).body(tempUserRepository.findById(email).get());
	}

}