package com.se.sample.basemvcservice.controller;

import com.se.sample.basemvcservice.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RestController
@RequestMapping("/api/books")
public class BookController {

    private final StorageService storageService;

    @Autowired
    public BookController(StorageService storageService) {
        this.storageService = storageService;
    }


    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        String filePath = storageService.storeFile(file);

        //http://localhost:8000/images/{file_name}
        return filePath;
    }

    @RequestMapping(value = "/upload/page", method = RequestMethod.POST)
    public String submit(@RequestParam("files") MultipartFile[] files) {

        return  "Success";
    }



}
