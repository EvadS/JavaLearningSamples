package org.o7planning.sbfileupload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class MainRESTController {

    // Linux: /home/{user}/test
    // Windows: C:/Users/{user}/test
    private static String UPLOAD_DIR = System.getProperty("user.home") + "/test";

    @PostMapping("test-post")
    public ResponseEntity<?> testPost(@RequestBody String name){
        Car car = new Car();
        car.setModel(name);
        return new ResponseEntity<Car>(car, HttpStatus.OK);

    }


    @GetMapping("/get-test")
    List<String > all() {
        return  new ArrayList<>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata"));
    }


    @PostMapping("/rest/uploadMultiFiles")
    public ResponseEntity<?> multiUploadFileModel(@ModelAttribute UploadForm form) {

        System.out.println("Description:" + form.getDescription());
        System.out.println("Test fields:" + form.getTestFields());


        String result = null;
        try {

            result = this.saveUploadedFiles(form.getFiles());

        }
        // Here Catch IOException only.
        // Other Exceptions catch by RestGlobalExceptionHandler class.
        catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("Uploaded to: <br/>" + result, HttpStatus.OK);
    }

    @PostMapping("/rest/uploadMultiFiles-car")
    public ResponseEntity<?> multiUploadFileModel2(@ModelAttribute UploadForm form,@RequestBody Car car) {

        System.out.println("Description:" + form.getDescription());
        System.out.println("car + " + car.getModel());

        String result = null;
        try {

            result = this.saveUploadedFiles(form.getFiles());

        }
        // Here Catch IOException only.
        // Other Exceptions catch by RestGlobalExceptionHandler class.
        catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("Uploaded to: <br/>" + result, HttpStatus.OK);
    }

    // Save Files
    private String saveUploadedFiles(MultipartFile[] files) throws IOException {

        // Make sure directory exists!
        File uploadDir = new File(UPLOAD_DIR);
        uploadDir.mkdirs();

        StringBuilder sb = new StringBuilder();

        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue;
            }
            String uploadFilePath = UPLOAD_DIR + "/" + file.getOriginalFilename();

            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadFilePath);
            Files.write(path, bytes);

            sb.append(uploadFilePath).append("<br/>");
        }
        return sb.toString();
    }
}