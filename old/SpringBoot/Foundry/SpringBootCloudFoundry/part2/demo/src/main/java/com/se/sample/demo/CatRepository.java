package com.se.sample.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

// <4>
@RepositoryRestResource
interface CatRepository extends JpaRepository<Cat, Long> {
}