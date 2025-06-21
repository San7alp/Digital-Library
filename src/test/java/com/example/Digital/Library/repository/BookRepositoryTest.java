package com.example.Digital.Library.repository;

import com.example.Digital.Library.DigitalLibraryApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DigitalLibraryApplication.class)
public class BookRepositoryTest {
    private final BookRepo br;

    public BookRepositoryTest(BookRepo br) {
        this.br = br;
    }

}
