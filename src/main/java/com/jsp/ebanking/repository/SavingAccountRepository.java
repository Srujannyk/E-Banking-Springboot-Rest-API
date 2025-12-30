package com.jsp.ebanking.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ebanking.entity.SavingBankAccount;

public interface SavingAccountRepository extends JpaRepository<SavingBankAccount, Long> {

}