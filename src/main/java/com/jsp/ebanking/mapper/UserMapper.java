package com.jsp.ebanking.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jsp.ebanking.dto.UserDto;
import com.jsp.ebanking.entity.User;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

	@Autowired
	protected PasswordEncoder passwordEncoder;

	@Mapping(target = "id", ignore = true)
    @Mapping(target = "password", expression = "java(passwordEncoder.encode(dto.getPassword()))")
    @Mapping(target = "role", expression = "java(BankingRole.valueOf(dto.getRole()))")
    @Mapping(target = "createdTime", ignore = true)
    @Mapping(target = "updatedTime", ignore = true)
    @Mapping(target = "bankAccount", ignore = true)
	public abstract User toEntity(UserDto dto);

	@Mapping(target = "password",expression = "java(\"***************\")")
	public abstract UserDto toDto(User user);

}