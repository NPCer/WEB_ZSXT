package com.miluyas.controller;

import com.miluyas.entity.Order;
import com.miluyas.entity.OrderVO;
import com.miluyas.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//需要返回视图，所以去掉只返回数据
@Controller
@RequestMapping("/client")
public class ClinetHandler {

    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public OrderVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        int index=(page-1)*limit;
        return orderFeign.findAll(index, limit);
    }

//    返回数据



    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String  location){
        return location;
    }


}
