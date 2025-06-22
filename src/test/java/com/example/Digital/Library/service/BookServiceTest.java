package com.example.Digital.Library.service;

import com.example.Digital.Library.entity.Book;
import com.example.Digital.Library.repository.BookRepo;
import com.example.Digital.Library.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepo br;

    @InjectMocks
    private BookService bs;

    static Book book = Book.builder()
            .id(UUID.randomUUID())
            .author("TestAuthor")
            .category(Book.Category.FICTION)
            .isbn("TestISBN")
            .name("TestName")
            .price(4000)
            .build();

    @Test
    void getAllBooks_whenThereAre3Books() {
        List<Book> bookList = Arrays.asList(
                book,
                book.withAuthor("TestAuthor2"),
                book.withPrice(1000)
        );

        Mockito.when(br.findAll()).thenReturn(bookList);
        List<Book> fetchedBookList = bs.getAllBooks();

        Assertions.assertEquals(bookList.size(), fetchedBookList.size());
    }
    @Test
    void getAllBooks_whenThereAreNoBooks(){
        List<Book> bookList=Arrays.asList();
        Mockito.when(br.findAll()).thenReturn(bookList);
        List<Book> fetchedBookList=bs.getAllBooks();
        Assertions.assertEquals(0,fetchedBookList.size());
    }
    @Test
    void getBookById(){
        Mockito.when(br.findById(book.getId())).thenReturn(Optional.of(book));
        Book b=this.bs.getBookById(book.getId());
        Assertions.assertEquals(book,b);
    }
}
