package com.devcolibri.dataexam.repository;

import com.devcolibri.dataexam.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepositroy extends JpaRepository<BankAccount, Long>{
}
