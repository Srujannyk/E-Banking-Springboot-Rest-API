package com.jsp.ebanking.repository;



import org.springframework.data.repository.CrudRepository;

import com.jsp.ebanking.entity.TempUser;

public interface TempUserRepository extends CrudRepository<TempUser, String> {

}