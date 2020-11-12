package com.sesample.notes.mapper;

import com.sesample.notes.entities.Note;
import com.sesample.notes.model.NoteRequest;
import com.sesample.notes.model.NoteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author Evgeniy Skiba on 12.11.2020
 * @project base-java-h2
 */

@Mapper
public interface NoteMapper {

    NoteMapper INSTANCE = Mappers.getMapper( NoteMapper.class );

    @Mappings({
            @Mapping(target="content", source="content"),
            @Mapping(target="title", source="title"),
            @Mapping(target="createdAt",  ignore = true),
            @Mapping(target="updatedAt",  ignore = true)

    })
    Note noteRequestToNote(NoteRequest noteReuest);


    @Mappings({
            @Mapping(target="content", source="content"),
            @Mapping(target="title", source="title"),
            @Mapping(target="id", source="id"),
            @Mapping(target="createdAt", source="createdAt"),
            @Mapping(target="updatedAt", source="updatedAt")
    })
    NoteResponse noteToNoteResponse(Note note);
}
