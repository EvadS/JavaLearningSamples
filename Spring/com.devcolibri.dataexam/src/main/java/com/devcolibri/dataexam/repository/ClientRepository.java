package com.devcolibri.dataexam.repository;

import com.devcolibri.dataexam.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
