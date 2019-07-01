package com.se.example.sarafan.repo;

import com.se.example.sarafan.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
