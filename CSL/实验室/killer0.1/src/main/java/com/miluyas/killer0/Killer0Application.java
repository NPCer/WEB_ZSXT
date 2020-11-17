package com.miluyas.killer0;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.miluyas.killer0.mapper")
public class Killer0Application {
    public static void main(String[] args){
        SpringApplication.run(Killer0Application.class, args);
    }
}
