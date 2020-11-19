package com.sesample.notes.repository;


import com.sesample.notes.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Evgeniy Skiba on 12.11.2020
 * @project base-java-h2
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}