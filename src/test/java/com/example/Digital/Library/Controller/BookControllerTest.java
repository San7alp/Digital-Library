package com.example.Digital.Library.Controller;

import com.example.Digital.Library.controller.BookController;
import com.example.Digital.Library.entity.Book;
import com.example.Digital.Library.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {
    @Mock
    private BookService bs;
    @InjectMocks
    private BookController bc;

    static Book book= Book.builder()
            .id(UUID.randomUUID())
            .author("TestAuthor")
            .category(Book.Category.FICTION)
            .isbn("TestISBN")
            .name("TestName")
            .price(4000)
            .build();
    @Test
    void addBook(){
        Mockito.when(this.bs.addBook(book)).thenReturn(book);
        ResponseEntity<Book>responseEntity=this.bc.addBook(book);
        Assertions.assertEquals(HttpStatus.CREATED,responseEntity.getStatusCode());
    }

}
