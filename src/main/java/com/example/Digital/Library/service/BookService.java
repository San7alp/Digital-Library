package com.example.Digital.Library.service;

import com.example.Digital.Library.entity.Book;
import com.example.Digital.Library.repository.BookRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class BookService {
    private BookRepo br;

    public BookService(BookRepo br) {
        this.br = br;
    }
    public Book addBook(Book b){
        log.info("Saving a book");
        Book saved= this.br.save(b);
        log.info("Saved book with id",saved.getId());
        return saved;
    }
    public List<Book> getAllBooks(){

        return this.br.findAll();
    }
    public Book getBookById(UUID id){
        Optional <Book> b=this.br.findById(id);
        if(b.isPresent()){
            return b.get();
        }
        else{
            return null;
        }
    }
}
