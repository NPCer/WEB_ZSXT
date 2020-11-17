package com.miluyas.killer0.entity;

import lombok.Data;

@Data
public class Book {
    private Integer bookId;
    private String description;
    private String bookName;
    private Integer stock;
    private Double price;
    private Integer categoryleveloneId;
    private Integer categoryleveltwoId;
    private String filename;
}
