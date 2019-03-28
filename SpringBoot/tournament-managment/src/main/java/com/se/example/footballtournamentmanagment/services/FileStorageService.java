package com.se.example.footballtournamentmanagment.services;

import com.se.example.footballtournamentmanagment.entity.FileStorage;
import com.se.example.footballtournamentmanagment.repository.FileStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileStorageService {
    @Autowired
    FileStorageRepository fileRepository;

    public FileStorage store(FileStorage fileStorageItem) {
        return fileRepository.save(fileStorageItem);
    }

    public boolean delete(Long playerID) {
        return false;
    }
}