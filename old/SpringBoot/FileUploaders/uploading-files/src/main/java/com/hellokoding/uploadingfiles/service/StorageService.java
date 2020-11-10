package com.hellokoding.uploadingfiles.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.io.IOException;
import java.nio.file.Files;


public class StorageService {

    @Value("${upload.path}")
    private String path;

//    void init(     MultipartFile[] fileDatas ) {
//        // Root Directory.
//        String uploadRootPath = request.getServletContext().getRealPath("upload");
//        System.out.println("uploadRootPath=" + uploadRootPath);
//
//        for (MultipartFile fileData : fileDatas) {
//
//            // Client File Name
//            String name = fileData.getOriginalFilename();
//            System.out.println("Client File Name = " + name);
//
//            if (name != null && name.length() > 0) {
//                try {
//                    // Create the file at server
//                    File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);
//
//                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
//                    stream.write(fileData.getBytes());
//                    stream.close();
//                    //
//                    uploadedFiles.add(serverFile);
//                    System.out.println("Write file: " + serverFile);
//                } catch (Exception e) {
//                    System.out.println("Error Write file: " + name);
//                    failedFiles.add(name);
//                }
//            }
//    }

    public void uploadFile(MultipartFile file) {

        if (file.isEmpty()) {
            throw new StorageException("Failed to store empty file");
        }

        try {
            String  fileName = file.getOriginalFilename();
            InputStream is = file.getInputStream();

            Files.copy(is, Paths.get(path + fileName),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {

            String msg = String.format("Failed to store file", file.getName());

            throw new StorageException(msg, e);
        }
    }
}