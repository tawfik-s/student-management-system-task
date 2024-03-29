package com.tawfeek.studentmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class StudentManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.tawfeek.studentmanagementsystem.StudentManagementSystemApplication.class, args);

    }
}
