package com.hellokoding.uploadingfiles;

import com.hellokoding.uploadingfiles.model.SignedTransactionDataModel;
import com.hellokoding.uploadingfiles.model.UploadModel;
import com.hellokoding.uploadingfiles.service.StorageService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    private static final String temp_file_name = "filename";
    StorageService storageService = new StorageService();

    @RequestMapping(method = RequestMethod.POST, value = "console")

    @ApiOperation(value = "Finds Pets by status",
            notes = "Multiple status values can be provided with comma seperated strings",
            response = String.class)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid file"),
            @ApiResponse(code = 404, message = " not found"),
            @ApiResponse(code = 200, message = "Success  uploaded ")})
    public String handleFileUpload(
            @ApiParam(value = "FILE FOR UPLOAD", required = true)
            @RequestParam("user-file") MultipartFile multipartFile) throws IOException {

        String name = multipartFile.getOriginalFilename();
        System.out.println("File name: " + name);
        //todo save to a file via multipartFile.getInputStream()
        byte[] bytes = multipartFile.getBytes();

        System.out.println("file received at: " + Instant.now().toString());
        System.out.println("size: " + bytes.length);


        System.out.println("File uploaded content:\n" + new String(bytes));

        System.out.println("---------------------------------------------------");

        return "file uploaded";
    }

    @RequestMapping(value = "/uploadMultiFile", method = RequestMethod.POST)
    public String uploadMultiFileHandlerPOST(HttpServletRequest request, //
                                             // @ModelAttribute MyUploadForm myUploadForm
                                             @RequestParam("user-file") MultipartFile multipartFile) {

        return this.doUpload(request, multipartFile);

    }

    private String doUpload(HttpServletRequest request, //
                            MultipartFile fileData) {

        String description = "Description";
        System.out.println("Description: " + description);

        // Root Directory.
        String uploadRootPath = request.getServletContext().getRealPath("upload");
        System.out.println("uploadRootPath=" + uploadRootPath);

        File uploadRootDir = new File(uploadRootPath);
        // Create directory if it not exists.
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        //
        List<File> uploadedFiles = new ArrayList<File>();
        List<String> failedFiles = new ArrayList<String>();

        //  for (MultipartFile fileData : fileDatas) {

        // Client File Name
        String name = fileData.getOriginalFilename();
        System.out.println("Client File Name = " + name);

        if (name != null && name.length() > 0) {
            try {
                // Create the file at server
                File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(fileData.getBytes());
                stream.close();
                //
                uploadedFiles.add(serverFile);
                System.out.println("Write file: " + serverFile);
                return serverFile.getAbsolutePath();
            } catch (Exception e) {
                System.out.println("Error Write file: " + name);
                failedFiles.add(name);
            }
        }
        // }

        // show uploaded to console

        return "uploadResult";
    }


    @PostMapping("/api/upload/multi/model")
    public ResponseEntity<?> multiUploadFileModel(@Valid @ModelAttribute UploadModel model) {

//        try {
//
        String name = model.getFiles().getOriginalFilename();
        System.out.println("File name: " + name);

//        } catch {
//            return new ResponseEntity<>(org.springframework.http.HttpStatus.ACCEPTED);
//        }

        return new ResponseEntity("Successfully uploaded!", org.springframework.http.HttpStatus.OK);

    }

    @RequestMapping(value = "/executesampleservice", method = RequestMethod.POST,
            consumes = {"multipart/form-data"})
    @ResponseBody
    public boolean executeSampleService(
            @RequestPart("properties") @Valid ConnectionProperties properties,
            @RequestPart("file") @Valid @NotNull @NotBlank MultipartFile file) {
        return true;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String handlePost(@RequestParam("user-file") MultipartFile multipartFile,
                             Model model) throws IOException {

        String name = multipartFile.getOriginalFilename();

        model.addAttribute("msg", "File has been uploaded:  " + name);
        return "response";
    }

    @PostMapping(value = "/test1")
    public void test1(@RequestBody MyModel model) {
        int a = 10;
    }


    @RequestMapping(value = "/confirmUploadLocalAttrFile_new", method =
            RequestMethod.POST)
    public String uploadConfirmLocalAttrHandler_new(@RequestParam("file") MultipartFile file,
                                                    HttpSession session,
                                                    @RequestParam("jsonStr") String inputdataJsonStr) {
        int aaa = 10;

        return  "success";
    }


    @PostMapping("/test-model")
    public  void testModel(@ModelAttribute MyModel model){
        int aa= 0;
    }


    @PostMapping("test-model2")
    public void testModel2(@ModelAttribute SignedTransactionDataModel model){
        System.out.println("1: " + model.getCertificateFile().getOriginalFilename());
        System.out.println("2: " + model.getData().length());
        System.out.println("3: " + model.getSignature());
    }

}