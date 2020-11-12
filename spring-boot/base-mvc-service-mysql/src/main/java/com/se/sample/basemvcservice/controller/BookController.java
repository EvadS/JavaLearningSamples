package com.se.sample.basemvcservice.controller;

import com.se.sample.basemvcservice.exception.ResourceNotFoundException;
import com.se.sample.basemvcservice.model.Book;
import com.se.sample.basemvcservice.payload.request.BookFullRequestModel;
import com.se.sample.basemvcservice.repository.BookRepository;
import com.se.sample.basemvcservice.service.StorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import java.util.List;


@Api(value = "Book controller)")
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    private final StorageService storageService;


    @Autowired
    BookRepository bookRepository;

    @Autowired
    public BookController(StorageService storageService) {
        this.storageService = storageService;
    }


    @ApiOperation(value = "Download book.", nickname = "book-download", notes = "Downoad book.", tags = {})
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @ApiOperation(value = "Upload cover of book.", nickname = "book-image-upload", notes = "Upload title.", tags = {})
    @PostMapping("/upload/title")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        String filePath = storageService.storeFile(file);

        //http://localhost:8000/images/{file_name}
        return filePath;
    }
    @ApiOperation(value = "Upload pages of book.", nickname = "book-images-upload", notes = "Upload pages.", tags = {})
    @RequestMapping(value = "/upload/page", method = RequestMethod.POST)
    public String submit(@RequestParam("files") MultipartFile[] uploaded) {

        /*
        String uploadedFileName = Arrays.stream(uploaded).map(x -> x.getOriginalFilename())
                .filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" , "));
         */
        return  "Success";
    }


    // maps html form to a Model
    @ApiOperation(value = "Create new book.", nickname = "book-images-upload",
            notes = "Create new book with title image", tags = {})
    @PostMapping("/book/full")
    public ResponseEntity<?> multiUploadFileModel(@ModelAttribute @Valid  BookFullRequestModel model) {
        logger.debug("Multiple file upload! With UploadModel");

           // saveUploadedFiles(Arrays.asList(model.getFiles()));
            // save to data base
        return new ResponseEntity("Successfully uploaded!", HttpStatus.OK);
    }

    @ApiOperation(value = "Get all books.", nickname = "book-crate",
            notes = "Get all books", tags = {})
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @ApiOperation(value = "Create book.", nickname = "book-create", notes = "Add new book.", tags = {})
    @PostMapping("/book")
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
        return ResponseEntity.ok(bookRepository.save(book));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("book", "id", bookId));

        return ResponseEntity.ok(book);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "id") Long bookId,
                           @Valid @RequestBody Book bookDetails) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", bookId));

        book.setName(bookDetails.getName());
        book.setAuthor(bookDetails.getAuthor());
        book.setYear(bookDetails.getYear());

        Book updatedBook = bookRepository.save(book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", bookId));

        bookRepository.delete(book);

        return ResponseEntity.ok().build();
    }
}
