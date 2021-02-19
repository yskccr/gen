package com.onekk.gen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@MapperScan("com.onekk.gen.mapper")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RungenApp {
    public static void main(String[] args) {
        SpringApplication.run(RungenApp.class,args);
    }
}
