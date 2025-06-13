package com.example.Digital.Library.controller;

import com.example.Digital.Library.entity.Book;
import com.example.Digital.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    private final BookService bs;
    @Autowired
    public BookController(BookService bs) {
        this.bs = bs;
    }
    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book b){
        Book saved=this.bs.addBook(b);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    @GetMapping("/getBooks")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(this.bs.getAllBooks(),HttpStatus.OK);
    }
    @GetMapping("{Bookid}") //finding book by id using path variable
    public ResponseEntity<Book> findbyid(@PathVariable UUID Bookid){
        return new ResponseEntity<>(this.bs.getBookById(Bookid),HttpStatus.FOUND);
    }
    @GetMapping("/") // finding book by id using request param
    public ResponseEntity<Book>findbyid1(@RequestParam UUID id){
        return new ResponseEntity<>(this.bs.getBookById(id),HttpStatus.FOUND);
    }
}
