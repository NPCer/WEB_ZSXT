package com.miluyas.killer0.vo;

import lombok.Data;
//VO view object 视图层

@Data
public class BookVO {
    private Integer bookId;
    private String description;
    private String bookName;
    private Integer stock;
    private Double price;
    private String categorylevelone;
    private String categoryleveltwo;//因为前端接口要的是名字
    private String filename;
}
