package com.docker.example.springpostgressample;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<BookEntity,String> {

    BookEntity findById(Long id);

}