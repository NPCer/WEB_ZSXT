package com.miluyas.killer0.controller;

import com.miluyas.killer0.service.BookService;
import com.miluyas.killer0.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//直接反JSON数据，不返回视图
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/list")
    public DataVO list(){
        return bookService.findData();

    }
    //请求映射
}
