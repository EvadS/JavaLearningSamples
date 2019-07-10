package com.devcolibri.dataexam.repository;

import com.devcolibri.dataexam.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
