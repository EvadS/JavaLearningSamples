package com.docker.example.springpostgressample;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RestService {
    private BookRepository bookRepository;

    @Autowired
    public RestService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public String getBookStats(Long id){
        BookEntity book= bookRepository.findById(id);
        String result="{ID : "+book.getId().toString()+",Title : "+book.getTitle()+",Author :"+ book.getAuthor()+" }";

        return result;
    }
}