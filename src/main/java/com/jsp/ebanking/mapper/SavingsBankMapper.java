package com.jsp.ebanking.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jsp.ebanking.dto.SavingAccountDto;
import com.jsp.ebanking.entity.SavingBankAccount;

@Mapper(componentModel = "spring")
public interface SavingsBankMapper {

	@Mapping(target = "aadharNumber", source = "aadhar")
	@Mapping(target = "panNumber", source = "pan")
	@Mapping(target = "ifscCode", expression = "java(\"EBNK000001\")")
	@Mapping(target = "branch", expression = "java(\"EBANK-DEFAULT\")")
	@Mapping(target = "balance", expression = "java(0.0)")
	@Mapping(target = "accountNumber", ignore = true)
	@Mapping(target = "active", ignore = true)
	@Mapping(target = "blocked", ignore = true)
	SavingBankAccount toEntity(SavingAccountDto dto);

}