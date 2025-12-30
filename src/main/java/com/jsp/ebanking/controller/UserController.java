package com.jsp.ebanking.controller;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.ebanking.dto.ResponseDto;
import com.jsp.ebanking.dto.SavingAccountDto;
import com.jsp.ebanking.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

	
		private final UserService userService;

		@GetMapping("/account/bank")
		public ResponseEntity<ResponseDto> viewSavingsAccount(Principal principal) {
			return userService.viewSavingsAccount(principal);
		}

		@PostMapping("/account/bank")
		public ResponseEntity<ResponseDto> createSavingsAccount(Principal principal,
				@RequestBody SavingAccountDto accountDto) {
			return userService.createSavingsAccount(principal, accountDto);
		}
	

}