package com.example.vhr.end;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.vhr.end.mapper")
public class VhrEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(VhrEndApplication.class, args);
    }

}
