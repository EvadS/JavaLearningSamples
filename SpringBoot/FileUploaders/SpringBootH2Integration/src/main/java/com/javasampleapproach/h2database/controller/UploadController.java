package com.javasampleapproach.h2database.controller;

import com.javasampleapproach.h2database.model.UploadForm;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/upload")
public class UploadController {


    @PostMapping("/uploadModel")
    public String multiFileUpload(@ModelAttribute UploadForm uploadForm) {

        int a =10;
//        StringJoiner sj = new StringJoiner(" , ");
//
//        for (MultipartFile file : form.getFiles()) {
//            if (file.isEmpty()) {
//                continue; //next pls
//            }
//            try {
//                byte[] bytes = file.getBytes();
//                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//                Files.write(path, bytes);
//
//               sj.add(file.getOriginalFilename());
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
            return "String";

    }


}
