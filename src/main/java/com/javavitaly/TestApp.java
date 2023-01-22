package com.javavitaly;

import com.javavitaly.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TestApp implements CommandLineRunner {
    @Autowired
    private FileService fileService;

    public static void main(String[] args) {
        SpringApplication.run(TestApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        fileService.FileOutService();
        fileService.printFindResult();
    }
}
