package com.docker.example.springpostgressample.repository;

import com.docker.example.springpostgressample.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<BookEntity,String> {

    BookEntity findById(Long id);

}