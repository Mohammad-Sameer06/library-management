package com.sameer.library.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String isbn;
    private boolean isIssued = false;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}