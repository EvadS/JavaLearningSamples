package com.sesample.notes.config;

import com.sesample.notes.entities.Note;
import com.sesample.notes.repository.NoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/**
 * @author Evgeniy Skiba on 14.11.2020
 * @project base-java-h2
 */
@Component
@Order(1)
class DataInitializer implements ApplicationRunner {
    private final NoteRepository noteRepository;

    DataInitializer(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {

        if(noteRepository.count()>=4){
            return;
        }

        Arrays.asList(
                new Note("Marten Deinum", "marten.deinum@conspect.nl"),
                new Note("Josh Long", "jlong@pivotal.io"),
                new Note("John Doe", "john.doe@island.io"),
                new Note("Jane Doe", "jane.doe@island.io"))
                .forEach(noteRepository::save);
    }

    @Component
    class NoteLister implements ApplicationRunner {
        private final Logger logger = LoggerFactory.getLogger(getClass());

        private final NoteRepository notereRepo;

        NoteLister(NoteRepository noteRepo) {
            this.notereRepo = noteRepo;
        }
        @Override
        public void run(ApplicationArguments args) {
            notereRepo.findAll().forEach(note -> logger.info("{}", note));
        }
    }
}