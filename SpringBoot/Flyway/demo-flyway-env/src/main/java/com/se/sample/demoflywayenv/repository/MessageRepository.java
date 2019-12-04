package com.se.sample.demoflywayenv.repository;

import com.se.sample.demoflywayenv.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}