package com.se.sample.thymeleafsample.repository;


import com.se.sample.thymeleafsample.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface NoteRepository extends JpaRepository<Note, Integer>{
    List<Note> findAllByOrderByDateAsc();
    List<Note> findAllByOrderByDateDesc();
}
