package com.sesample.notes.controller;

import com.sesample.notes.entities.Note;
import com.sesample.notes.exception.ResourceNotFoundException;
import com.sesample.notes.mapper.NoteMapper;
import com.sesample.notes.model.NoteRequest;
import com.sesample.notes.model.NoteResponse;
import com.sesample.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * @author Evgeniy Skiba on 12.11.2020
 * @project base-java-h2
 */

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    @GetMapping("/notes")
    public List<NoteResponse> getAllNotes() {
        return noteRepository.findAll().stream()
                .map(NoteMapper.INSTANCE::noteToNoteResponse)
                .collect(Collectors.toList());
    }

    @PostMapping("/notes")
    public ResponseEntity<NoteResponse> createNote(@Valid @RequestBody NoteRequest noteRequest) {

        Note note = NoteMapper.INSTANCE.noteRequestToNote(noteRequest);
        noteRepository.save(note);

        NoteResponse noteResponse = NoteMapper.INSTANCE.noteToNoteResponse(note);
        return  ResponseEntity.ok(noteResponse);

    }

    @GetMapping("/notes/{id}")
    public NoteResponse getNoteById(@PathVariable(value = "id") Long noteId) {

        Note note =  noteRepository.findById(noteId)
                .orElseThrow(
                        () -> new IllegalStateException("Couldn't find any index set config!"));

        return  NoteMapper.INSTANCE.noteToNoteResponse(note);
    }

    @PutMapping("/notes/{id}")
    public ResponseEntity<NoteResponse> updateNote(@PathVariable(value = "id") Long noteId,
                           @Valid @RequestBody Note noteDetails) {

        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Note updatedNote = noteRepository.save(note);
        NoteResponse noteResponse =  NoteMapper.INSTANCE.noteToNoteResponse(updatedNote);
        return ResponseEntity.ok(noteResponse);
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        noteRepository.delete(note);
        return ResponseEntity.ok().build();
    }
}