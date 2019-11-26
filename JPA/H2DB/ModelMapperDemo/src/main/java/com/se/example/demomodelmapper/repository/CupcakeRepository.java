package com.se.example.demomodelmapper.repository;

import com.se.example.demomodelmapper.entity.Cupcake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 01.02.19
 * e-mail: 2262288@gmail.com
 */
@Repository
public interface CupcakeRepository extends JpaRepository<Cupcake, Long> {

    List<Cupcake> findAllByIdIn(List<Long> ids);
}