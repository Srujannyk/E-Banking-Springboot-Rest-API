package com.jsp.ebanking.service;


import org.springframework.http.ResponseEntity;

import com.jsp.ebanking.dto.ResponseDto;

public interface AdminService {

	ResponseEntity<ResponseDto> getPendingAccounts();

	ResponseEntity<ResponseDto> getUser(Long accountNumber);

	ResponseEntity<ResponseDto> approveBankAccount(Long accountNumber);

}