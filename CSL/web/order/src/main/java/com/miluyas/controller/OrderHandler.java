package com.miluyas.controller;


import com.miluyas.entity.Order;
import com.miluyas.entity.OrderVO;
import com.miluyas.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderHandler {
    @Value("${server.port}")
    private String port;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/index")
    public String index(){
        return this.port;
    }
    @GetMapping("/findAll/{index}/{limit}")
    public OrderVO findAll(@PathVariable("index")int index, @PathVariable("limit") int limit){

        return new OrderVO(0,"",100,orderRepository.findAll(index, limit));

    }

}
