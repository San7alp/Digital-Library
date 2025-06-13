package com.example.Digital.Library.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private String author;

    @Column(unique = true)
    private String isbn;

    private double price;

    private String description;

    @Enumerated
    private Category category;

    public enum Category{
        FICTION,
        NON_FICTION
    }

}
