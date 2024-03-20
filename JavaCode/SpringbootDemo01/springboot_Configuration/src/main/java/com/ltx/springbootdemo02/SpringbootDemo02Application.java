package com.ltx.springbootdemo02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootDemo02Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext rongqi = SpringApplication.run(SpringbootDemo02Application.class, args);
        BookController bookControllerBean = rongqi.getBean(BookController.class);
    }

}
