package com.se.sample.basemvcservice.controller;

import com.se.sample.basemvcservice.payload.request.BookFullRequestModel;
import com.se.sample.basemvcservice.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Arrays;


@RestController
@RequestMapping("/api/books")
public class BookController {

    private final Logger logger = LoggerFactory.getLogger(BookController.class);

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
    public String submit(@RequestParam("files") MultipartFile[] uploaded) {

        /*
        String uploadedFileName = Arrays.stream(uploaded).map(x -> x.getOriginalFilename())
                .filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" , "));
         */
        return  "Success";
    }


    // maps html form to a Model
    @PostMapping("/api/upload/multi/model")
    public ResponseEntity<?> multiUploadFileModel(@ModelAttribute @Valid  BookFullRequestModel model) {

        logger.debug("Multiple file upload! With UploadModel");



           // saveUploadedFiles(Arrays.asList(model.getFiles()));
            // save to data base


        return new ResponseEntity("Successfully uploaded!", HttpStatus.OK);

    }
}
