package com.battcn.chapter1;

import com.alibaba.druid.pool.DruidDataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

import javax.sql.DataSource;


@SpringBootApplication
@RestController
public class Chapter1Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter1Application.class, args);
    }

    @GetMapping("/chapter")
    public  String chapter(){
        return "hello LiuYang";
    }


//    @Bean
////    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
////        // 目的是
////        return args -> {
////            System.out.println("来看看 SpringBoot 默认为我们提供的 Bean：");
////            String[] beanNames = ctx.getBeanDefinitionNames();
////            Arrays.sort(beanNames);
////            Arrays.stream(beanNames).forEach(System.out::println);
////        };
////    }

}
