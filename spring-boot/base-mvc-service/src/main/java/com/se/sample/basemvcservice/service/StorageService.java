package com.se.sample.basemvcservice.service;

import com.se.sample.basemvcservice.exception.FileNotFoundException;
import com.se.sample.basemvcservice.exception.FileStorageException;
import com.se.sample.basemvcservice.exception.IncorrectFileException;
import com.se.sample.basemvcservice.exception.StorageException;
import com.se.sample.basemvcservice.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


// TODO: 1. Create base interface
// TODO: 2. Implement for db storing / file store / S3 store
@Service
public class StorageService {

    private  Path rootLocation ;

    @Autowired
    public StorageService() {
        this.rootLocation = Paths.get(AppConstants.STORAGE_LOCATION);
    }

    // TODO: refactored to use array of files
    public String storeFile(MultipartFile file) {
        // Normalize file name
        String filename = StringUtils.cleanPath(file.getOriginalFilename());

        Path filePath = this.rootLocation.resolve(filename);

        // add constraint
        if (file.isEmpty()) {
            throw new IncorrectFileException("Failed to store empty file " + filename);
        }

        try {
            // Check if the file's name contains invalid characters
            if(filename.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + filename);
            }

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, this.rootLocation.resolve(filename),
                        StandardCopyOption.REPLACE_EXISTING);
            }

            return filePath.toString();

        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + filename + ". Please try again!", ex);
        }
    }

    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new FileNotFoundException(
                        "Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new FileNotFoundException("Could not read file: " + filename, e);
        }
    }

    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }
}
