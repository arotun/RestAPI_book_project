package com.assigment2TA.book;
import jakarta.persistence.*;
import lombok.*;

import java.util.Enumeration;
import java.util.Locale;


@Entity
@Table(name="Book")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String  title;

    @Column
    private String description;

    @Column
    private String published_year;

    @Column (nullable = false)
    private String author;

    @Enumerated(EnumType.STRING)
    @Column
    private Category category;

}

enum Category {
    IT,
    Math,
    Physics,
    Economy;
}




