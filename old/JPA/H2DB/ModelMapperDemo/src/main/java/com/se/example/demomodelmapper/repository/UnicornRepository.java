package com.se.example.demomodelmapper.repository;


import com.se.example.demomodelmapper.entity.Unicorn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UnicornRepository extends JpaRepository<Unicorn, Long> {
}
